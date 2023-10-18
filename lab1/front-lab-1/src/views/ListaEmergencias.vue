<template>
  <div class="m-auto flex gap-10 p-10 min-w-[35%] items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md min-w-[20rem]">
      <div class="flex flex-col items-center">
        <h1>Lista de Emergencias:</h1>
        <div class="flex flex-col w-fit gap-2">
          <div
            v-for="(emergency, index) in emergenciesList"
            class="flex flex-row bg-slate-100 shadow-lg justify-between rounded-lg overflow-hidden"
            :key="emergency.id_emergency">
            <div class="m-2">
              <p>ID Emergencia: {{ emergency.id_emergency }}</p>
              <p>Nombre: {{ emergency.name }}</p>
              <p>Descripción: {{ emergency.description }}</p>
              <p>Estado: {{ emergency.state }}</p>
              <p>ID Institución: {{ emergency.id_institution }}</p>
              <p>Tareas activas: {{ emergency.activeTasks }}</p>
            </div>
            <button
              @click="FuncionalidadBoton(index)"
              class="p-2 h-fit rounded-xl shadow-md"
              :class="{
                'bg-green-400': emergency.state === 0,
                'bg-red-400': emergency.state === 1,
              }">
              {{ emergency.state === 0 ? "activar" : "desactivar" }}
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
import { store } from "../store";
const error = ref(null);
const emergenciesList = ref([]);
const url = "http://localhost:3000";

const FuncionalidadBoton = async (index) => {
  emergenciesList[index].state = !emergenciesList[index].state
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
