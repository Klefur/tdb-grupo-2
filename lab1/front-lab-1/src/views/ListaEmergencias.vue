<template>
	<div>
		<h1>This is an about page</h1>
	</div>
	<h2>Total de Emergencias activas: {{ tareasActivasTotal }}</h2>
	<div class="flex flex-col items-center">
		<h1>Lista de Emergencias:</h1>

		<div
			class="flex flex-col items-center bg-gray-400 border w-fit rounded-xl"
		>
			<div
				v-for="(item, index) in listaEmergencias"
				class="flex flex-row bg-slate-400 border border-black"
				:key="index"
			>
				<p>
					{{ item }}
				</p>
				<button
					@click="FuncionalidadBoton(index)"
					class="bg-green-400 p-2"
				>
					activar
				</button>
			</div>
		</div>
	</div>
</template>

<script setup>
function FuncionalidadBoton(x) {
	console.log(x);
}
function GetDatos() {
	const datos = {
		lista: [1, 2, 3, 4, 5],
		total: 2,
	};
	return datos;
}
const apiResponse = GetDatos();
const listaEmergencias = apiResponse.lista;
const tareasActivasTotal = apiResponse.total;
</script>
