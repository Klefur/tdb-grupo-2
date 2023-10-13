<template>   
  <div class="m-auto flex gap-10 p-10 min-w-[35%] items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md w-80">
      <h2>Total de Emergencias activas: {{ tareasActivasTotal }}</h2>
      <div class="flex flex-col items-center">
        <h1>Lista de Emergencias:</h1>

        <div
          class="flex flex-col w-fit gap-2"
        >
          <div
            v-for="(item, index) in listaEmergencias"
            class="flex flex-row bg-slate-400 shadow-lg w-72 justify-between rounded-lg overflow-hidden"
            :key="index"
          >
            <p class="m-2">
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
    </div>
  </div>
</template>

<script setup>
function FuncionalidadBoton(x) {
  console.log(x);
}
function GetDatos() {
  const datos = {
    lista: ["aaaaaaaaa", 2, 3, 4, 5],
    total: 2,
  };
  return datos;
}
const apiResponse = GetDatos();
const listaEmergencias = apiResponse.lista;
const tareasActivasTotal = apiResponse.total;
</script>
