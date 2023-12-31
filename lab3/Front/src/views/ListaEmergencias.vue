<template>
	<div class="m-auto flex gap-10 p-10 min-w-[35%] items-center justify-center">
		<div class="bg-white p-8 rounded-lg shadow-md min-w-[20rem]">
			<div class="flex flex-row mb-4 justify-center items-center gap-2">
				<label for="radio" class="align-center padding-right-20"><b>Radio de búsqueda: </b>
				</label>
				<input list="radios" v-model.number="radio" placeholder="Ingrese un radio en [km]"
					class="border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 block w-35 sm:text-sm"
					type="number" min="0" max="200" />
				<datalist id="radios">
					<option value="10">10 km</option>
					<option value="20">20 km</option>
					<option value="50">50 km</option>
					<option value="100">100 km</option>
					<option value="200">200 km</option>
				</datalist>
			</div>

			<h1 class="text-center mb-5 font-bold text-xl">
				Lista de Emergencias:
			</h1>
			<div v-if="emergenciesList.length">
				<div class="max-h-[50vh] overflow-y-scroll">
					<div v-for="(emergency, index) in emergenciesList" :key="emergency.id_emergency"
						class="flex justify-between items-center bg-slate-100 shadow-lg p-4 rounded-lg mb-3">
						<div class="flex flex-col items-start justify-center m-2" style="min-width: 0">
							<p>
								<strong>ID Emergencia:</strong>
								{{ emergency.id_emergency }}
							</p>
							<p><strong>Nombre:</strong> {{ emergency.name }}</p>
							<p class="break-words w-[calc(100%-rem)]">
								<strong>Descripción:</strong>
								{{ emergency.description }}
							</p>
							<p><strong>Estado:</strong> {{ emergency.state }}</p>
							<p>
								<strong>ID Institución:</strong>
								{{ emergency.id_institution }}
							</p>
							<p>
								<strong>Tareas activas:</strong>
								{{ emergency.activeTasks }}
							</p>
						</div>

						<div class="flex flex-col space-y-2 justify-center items-end w-40">
							<button @click="toggleEmergencyStatus(index)" class="p-2 rounded-xl shadow-md w-32 px-1 py-2"
								:class="buttonColor(emergency.state)" style="min-width: 70px">
								{{ buttonText(emergency.state) }}
							</button>
							<button @click="GetPoints(emergency.id_emergency, index)"
								class="p-2 rounded-xl shadow-md bg-slate-500 w-32 px-1 py-2">
								Ver voluntarios
							</button>
						</div>
					</div>
				</div>
			</div>
			<p v-else class="text-center text-gray-500">
				No hay emergencias registradas.
			</p>
		</div>
		<div v-if="show_map || true" class="flex flex-row gap-5 h-[65vh]">
			<div class="w-[50vh]  rounded-xl overflow-hidden">
				<Map :points="points" />
			</div>
			<div class="bg-white p-8 rounded-lg shadow-xl min-w-[20rem] overflow-scroll">
				<div v-for="(voluntary, index) in points.list" :key="voluntary.id_voluntary"
					class="flex justify-between items-center bg-slate-100 shadow-lg p-4 rounded-lg mb-3">
					<div class="flex flex-col items-start justify-center m-2" style="min-width: 0">
						<p>
							<strong>ID Voluntario:</strong>
							{{ voluntary.id_voluntary }}
						</p>
						<p><strong>Nombre:</strong> {{ voluntary.fullname }}</p>
						<p><strong>Estado:</strong> {{ voluntary.state ? "Activo/a" : "Inactivo/a" }}</p>
						<p class="break-words"><strong>Email:</strong> {{ voluntary.email }}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>
import { reactive, ref, onMounted } from "vue";
import axios from "axios";
import { store } from "../store";
import Map from "../components/Map.vue";

const error = ref(null);
const emergenciesList = ref([]);
const show_map = ref(false);
const radio = ref(0);

const url = "http://localhost:3000";

const buttonText = (state) => {
	return state === "0" ? "Activar" : "Desactivar";
};

const buttonColor = (state) => {
	return state === "0" ? "bg-green-400" : "bg-red-400";
};

const toggleEmergencyStatus = async (index) => {
	const currentEmergency = emergenciesList.value[index];

	if (!currentEmergency) {
		console.error("No se encontró la emergencia con el índice: ", index);
		return;
	}

	if (currentEmergency.state === "0") {
		await axios.put(`${url}/${currentEmergency.id_emergency}/toggle/1`);
	} else {
		await axios.put(`${url}/${currentEmergency.id_emergency}/toggle/0`);
	}

	emergenciesList.value[index] = {
		...currentEmergency,
		state: currentEmergency.state === "0" ? "1" : "0",
	};
};

async function GetDatos() {
	try {
		const listResponse = await axios.get(
			`${url}/emergencies?token=${store.token}`,
		);
		const emergenciesData = listResponse.data;

		for (let emergency of emergenciesData) {
			const tasksResponse = await axios.get(
				`${url}/countTasks/${emergency.id_emergency}?token=${store.token}`,
			);
			emergency.activeTasks = tasksResponse.data;

			emergenciesList.value.push(emergency);
		}
	} catch (err) {
		error.value = err.message;
		console.error("Error en la petición: ", error.value);
	}
}

const points = reactive({ list: [], emergency: {}, radius: 1 });

async function GetPoints(id_emergencia, index) {
	await axios
		.get(
			url +
			"/emergencies_voluntaries/location/" +
			String(id_emergencia) +
			"/" +
			String(radio.value * 1000),
		)
		.then((response) => {
			console.log(response);
			points.list = response.data;
			points.emergency = emergenciesList.value[index];
			points.radius = radio.value * 1000;
			show_map.value = true;
		})
		.catch((error) => {
			console.log(error);
		});
}

onMounted(async () => {
	try {
		const response = await axios.get(
			`${url}/emergencies?token=${store.token}`,
		);
		console.log(response);
	} catch (err) {
		console.error("Error en la petición: ", err.message);
	}
	GetDatos();

});
</script>
