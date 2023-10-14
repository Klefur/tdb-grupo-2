<template>
  <div class="m-auto flex gap-10 p-10 min-w-[35%] items-center justify-center">
    <div class="bg-white p-8 rounded-lg shadow-md min-w-[20rem]">
      <h2>
        Total de Emergencias activas:
        {{ totalActiveTasks }}
      </h2>
      <div class="flex flex-col items-center">
        <h1>Lista de Emergencias:</h1>
        <div class="flex flex-col w-fit gap-2">
          <div
            v-for="emergency in emergenciesList"
            class="flex flex-row bg-slate-100 shadow-lg justify-between rounded-lg overflow-hidden"
            :key="emergency.id_emergency">
            <div class="m-2">
              <p>ID Emergencia: {{ emergency.id_emergency }}</p>
              <p>Nombre: {{ emergency.name }}</p>
              <p>Descripción: {{ emergency.description }}</p>
              <p>Estado: {{ emergency.state }}</p>
              <p>ID Institución: {{ emergency.id_institution }}</p>
              <p>Tareas activas: {{ emergency.totalActiveTasks }}</p>
            </div>
            <button
              @click="FuncionalidadBoton(id_emergency)"
              class="p-2 h-fit rounded-xl shadow-md"
              :class="{
                'bg-green-400': emercency.state === 0,
                'bg-red-400': emercency.state === 1,
              }">
              {{ emercency.state === 0 ? "activar" : "desactivar" }}
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
const totalActiveTasks = ref(0);
const url = "http://localhost:3000";

const FuncionalidadBoton = async (id) => {
  const data = {};
  console.log(data);

  await axios
    .post(url + "/uhhh", data)
    .then((response) => {
      store.token = response.data;
      console.log(response);
      console.log(response.data);
    })
    .catch((error) => {
      console.error("Error en la solicitud:", error);
    });
  // suponiendo que el axios de arriba no actualiza la lista
  GetDatos();
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
      emergency.totalActiveTasks = tasksResponse.data;
      //Calcular total de tareas activas, pero no es atributo de emergency
      const tasksData = tasksResponse.data;
      totalActiveTasks.value += tasksData;

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
