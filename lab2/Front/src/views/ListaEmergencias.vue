<template>
  <div class="m-auto flex gap-10 p-10 min-w-[35%] items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md min-w-[20rem]">

      <div>
        <p>Radio</p>
        <input type="number" v-model.number="radio">
      </div>

      <h1 class="text-center mb-5 font-bold text-xl">Lista de Emergencias:</h1>
      <div v-if="emergenciesList.length">
        <div 
          v-for="(emergency, index) in emergenciesList" 
          :key="emergency.id_emergency"
          class="flex justify-between items-center bg-slate-100 shadow-lg p-4 rounded-lg mb-3"
        >
          <div class="flex flex-col items-start justify-center m-2">
            <p><strong>ID Emergencia:</strong> {{ emergency.id_emergency }}</p>
            <p><strong>Nombre:</strong> {{ emergency.name }}</p>
            <p class="break-words w-[calc(100%-rem)]"><strong>Descripción:</strong> {{ emergency.description }}</p>
            <p><strong>Estado:</strong> {{ emergency.state }}</p>
            <p><strong>ID Institución:</strong> {{ emergency.id_institution }}</p>
            <p><strong>Tareas activas:</strong> {{ emergency.activeTasks }}</p>
          </div>
          <button
            @click="FuncionalidadBoton(index)"
            class="p-2 rounded-xl shadow-md"
            :class="buttonColor(emergency.state)"
          >
            {{ buttonText(emergency.state) }}
          </button>
          <button
            @click="GetPoints(index)"
            class="p-2 rounded-xl shadow-md bg-slate-500"
          >
            Ver noseque
          </button>
        </div>
      </div>
      <p v-else class="text-center text-gray-500">No hay emergencias registradas.</p>
    </div>
    <div class="w-[500px] h-[500px]">
      <Map :points="points" />
    </div>
  </div>

  
</template>

<script setup>
import { reactive, ref, onMounted } from "vue";
import axios from "axios";
import { store } from "../store";
import Map from '../components/Map.vue';

const error = ref(null);
const emergenciesList = ref([]);

const radio = ref(0);

const url = "http://localhost:3000";

const buttonText = (state) => {
  return state === '0' ? 'Activar' : 'Desactivar';
}

const buttonColor = (state) => {
  return state === '0' ? 'bg-green-400' : 'bg-red-400';
}


const FuncionalidadBoton = async (index) => {
  const currentEmergency = emergenciesList.value[index];
  
  if(!currentEmergency){
    console.error("No se encontró la emergencia con el índice: ", index);
    return;
  }

  if(currentEmergency.state === '0'){
    await axios.put(
      `${url}/${currentEmergency.id_emergency}/toggle/1`
    );
  } else {
    await axios.put(
      `${url}/${currentEmergency.id_emergency}/toggle/0`
    );
  }

  currentEmergency.state = currentEmergency.state === '0' ? '1' : '0';
};

async function GetDatos() {
  try {
    const listResponse = await axios.get(
      `${url}/emergencies?token=${store.token}`
    );
    const emergenciesData = listResponse.data;

    for (let emergency of emergenciesData) {
      const tasksResponse = await axios.get(
        `${url}/countTasks/${emergency.id_emergency}?token=${store.token}`
      );
      emergency.activeTasks = tasksResponse.data;

      emergenciesList.value.push(emergency);
    }
  } catch (err) {
    error.value = err.message;
    console.error("Error en la petición: ", error.value);
  }
}

const points = reactive({ list: [
    ]});

async function GetPoints(id_emergencia) {
  await axios.get(url + "/voluntaries/location/" + String(id_emergencia) + "/" + String(radio.value))
  .then((response) => {
    console.log(response);
    points.list = response.data;
  })
  .catch((error) => {
    console.log(error);
  });
}

onMounted(async () => {
  try {
    const response = await axios.get(`${url}/emergencies?token=${store.token}`);
    console.log(response);
  } catch (err) {
    console.error("Error en la petición: ", err.message);
  }
  GetDatos();
});

</script>
