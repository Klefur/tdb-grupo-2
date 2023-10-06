<template>
	<div>
		<h1>This is an about page</h1>
	</div>
	<h1>Lista de Emergencias:</h1>
	<h2>Total de Emergencias activas: {{ tareasActivasTotal }}</h2>
	<div v-for="(item, index) in listaEmergencias" :key="index">
		{{ item }}
	</div>
</template>

<script setup>
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
