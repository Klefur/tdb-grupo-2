<template>
    <div class="flex flex-col gap-4 w-[50%] bg-sky-200 p-4 rounded-lg">
        <div class="flex flex-row gap-20 w-full">
            <input v-model="search" class="rounded-lg pl-4" placeholder="Buscar tarea..." />
            <Boton label="+ Añadir Tarea" href="/" @click="createNewTask()" class="bg-orange-400 hover:bg-orange-500"/>
        </div>
  
      <ul class="flex flex-auto">
      <li v-for="task in tasks" :key="task.id" class="flex flex-row w-full justify-between"> 
        <div class="bg-white flex flex-row w-full justify-between p-4 rounded-lg shadow-md hover:shadow-lg transition-shadow duration-200">
      <p class="">{{ task.title }}</p>
      <p class="">{{ task.description }}</p>
      <p class=" text-gray-500">2023-08-23</p>
      <div class="flex flex-row gap-3 justify-between items-center">
        <button @click="openEditModal(task)" class="text-blue-500 hover:underline">Editar</button>
        <button @click="emitDelete()" class="text-red-500 hover:underline">Eliminar</button>
        <input type="checkbox" v-model="task.completed" @change="emitComplete">
      </div>
    </div>
      </li>
    </ul>

    <!-- Modal para editar la tarea -->
    <div v-if="showEditModal" class="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-black bg-opacity-50">
      <div class="bg-white p-5 rounded-lg shadow-lg w-1/3">
        <h2 class="text-2xl mb-4">Editar Tarea</h2>
        <input v-model="taskEdit.title" placeholder="Título" class="border p-2 rounded mb-2 w-full">
        <textarea v-model="taskEdit.description" placeholder="Descripción" class="border p-2 rounded mb-2 w-full"></textarea>
        <input type="date" v-model="taskEdit.dueDate" class="border p-2 rounded mb-2 w-full">
        <button @click="saveEdit()" class="bg-blue-500 text-white p-2 rounded mr-2">Guardar</button>
        <button @click="closeEditModal()" class="bg-gray-400 text-white p-2 rounded">Cerrar</button>
      </div>
    </div>

    </div>
  </template>
  
<script setup>
import { useRouter } from "vue-router";
import { store  } from "../store";
import axios from 'axios' 
import { ref, onMounted } from "vue"
import Input from "../components/Input.vue"
import Boton from "../components/Boton.vue"

const url = 'http://localhost:8086'

let tasks = ref(null)
let showEditModal = ref(false)

let taskEdit = {
    id: null,
    title: null,
    description: null,
    dueDate: null
}

onMounted(async () => {
	try {
		const response = await axios.get(url + '/home?token=' + store.token)
		tasks.value = response.data
        console.log(tasks)

	} catch (error) {
		console.error('Error fetching data:', error)
	}
})

const createNewTask = async () => {

    await axios.post(url + '/new-task?token=' + store.token)
    .then(response => {
    tasks = response.data
    console.log('Respuesta del servidor:', response.data)
    })
    .catch(error => {
        console.error('Error en la solicitud:', error)

})
}

const openEditModal = (taskToEdit) => {
    taskEdit.id = taskToEdit.id;
    taskEdit.title = taskToEdit.title;
    taskEdit.description = taskToEdit.description;
    taskEdit.dueDate = taskToEdit.dueDate;
    console.log(taskEdit)
    showEditModal.value = true;
}

const saveEdit = async () => {
    // Actualiza la tarea en la lista local
    tasks.value[taskEdit.id.value] = { ...taskEdit };

    // Opcional: Guarda los cambios en el servidor
    try {
        await axios.put(url + "/update-task/" + taskEdit.id + "?token=" + store.token, taskEdit);
        console.log('Tarea actualizada con éxito en el servidor.');
    } catch (error) {
        console.error('Error al actualizar la tarea:', error);
    }

    // Cierra el modal y reinicia el índice de edición y el objeto de edición
    closeEditModal();
    taskEdit = {
        id: null,
        title: null,
        description: null,
        dueDate: null
    };
}


const closeEditModal = async () => {
    showEditModal.value = false;
}


 
</script>
  