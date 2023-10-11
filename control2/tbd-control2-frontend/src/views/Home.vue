<template>
    <div class="flex flex-col gap-4 w-[50%] bg-sky-600 p-4 rounded-lg">
        <div class="flex flex-row gap-20 w-full">
            <input v-model="search" class="rounded-lg pl-4" placeholder="Buscar tarea..." />
            <Boton label="+ Añadir Tarea" @click="openNewTaskModal()" class="bg-orange-400 hover:bg-orange-500"/>
        </div>

        <div class="flex flex-row w-full gap-5 text-sm">
            <button @click="showAllTasks()" class=" bg-white hover:bg-slate-200 shadow p-2 rounded-lg ">Ver todas las tareas</button>
            <button @click="showCompletedTasks()" class=" bg-white hover:bg-slate-200 shadow p-2 rounded-lg ">Ver lista de tareas completadas</button>
            <button @click="showToDoTasks()" class=" bg-white hover:bg-slate-200 shadow p-2 rounded-lg ">Ver lista de tareas pendientes</button>
        </div>
  
      <!-- Lista de tareas -->
      <ul class="flex flex-col gap-2">
      <li v-for="task in tasks" :key="task.id" class="flex flex-row w-full justify-between"> 
        <div class="bg-white flex flex-row w-full justify-between p-4 rounded-lg shadow-md hover:shadow-lg transition-shadow duration-200">
      <p class="">{{ task.title }}</p>
      <p class="">{{ task.description }}</p>
      <p class=" text-gray-500">{{ task.expire_date }}</p>
      <div class="flex flex-row gap-3 justify-between items-center">
        <button @click="openEditModal(task, index)" class="text-blue-500 hover:underline">Editar</button>
        <button @click="openDeleteModal(task.id, index)" class="text-red-500 hover:underline">Eliminar</button>
        <input type="checkbox" v-model="task.completed" @change="taskComplete(task)">
      </div>
    </div>
      </li>
    </ul>

    <!-- Modal para añadir una nueva tarea -->
<div v-if="showAddModal" class="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-black bg-opacity-50">
    <div class="bg-white p-5 rounded-lg shadow-lg w-1/3">
        <h2 class="text-2xl mb-4">Añadir Tarea</h2>
        <input v-model="taskEdit.title" placeholder="Título" class="border p-2 rounded mb-2 w-full">
        <textarea v-model="taskEdit.description" placeholder="Descripción" class="border p-2 rounded mb-2 w-full"></textarea>
        <input type="date" v-model="taskEdit.expire_date" class="border p-2 rounded mb-2 w-full">
        <button @click="createNewTask()" class="bg-blue-500 text-white p-2 rounded mr-2">Guardar</button>
        <button @click="closeNewTaskModal()" class="bg-gray-400 text-white p-2 rounded">Cerrar</button>
    </div>
</div>

    <!-- Modal para editar la tarea -->
    <div v-if="showEditModal" class="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-black bg-opacity-50">
      <div class="bg-white p-5 rounded-lg shadow-lg w-1/3">
        <h2 class="text-2xl mb-4">Editar Tarea</h2>
        <input v-model="taskEdit.title" placeholder="Título" class="border p-2 rounded mb-2 w-full">
        <textarea v-model="taskEdit.description" placeholder="Descripción" class="border p-2 rounded mb-2 w-full"></textarea>
        <input type="date" v-model="taskEdit.expire_date" class="border p-2 rounded mb-2 w-full">
        <button @click="saveEdit()" class="bg-blue-500 text-white p-2 rounded mr-2">Guardar</button>
        <button @click="closeEditModal()" class="bg-gray-400 text-white p-2 rounded">Cerrar</button>
      </div>
    </div>

    <!-- Modal para eliminar la tarea -->
    <div v-if="showDeleteModal" class="fixed top-0 left-0 w-full h-full flex items-center justify-center bg-black bg-opacity-50">
      <div class="bg-white p-5 rounded-lg shadow-lg w-1/3">
        <h2 class="text-2xl mb-4">Eliminar Tarea</h2>
        <h3>Atenção!</h3>
        <p>Esta acción no puede revertirse.</p>
        <button @click="deleteTask()" class="bg-red-500 text-white p-2 rounded mr-2">Eliminar</button>
        <button @click="closeDeleteModal()" class="bg-gray-400 text-white p-2 rounded">Cerrar</button>
      </div>
    </div>

    </div>
  </template>
  
<script setup>
import { useRouter } from "vue-router";
import { store  } from "../store";
import axios, { all } from 'axios' 
import { ref, onMounted, watch } from "vue"
import Input from "../components/Input.vue"
import Boton from "../components/Boton.vue"

const url = 'http://localhost:8086'

let noTasks = true
let task = ref()
const search = ref("")
const allTasks = ref([])
let tasks = ref([])
let showAddModal = ref(false)
let showEditModal = ref(false)
let showDeleteModal = ref(false)
let editingTaskIndex = ref(null);

let taskEdit = {
    id: null,
    title: null,
    description: null,
    expire_date: null
}

onMounted(async () => {
	try {
		const response = await axios.get(url + '/home?token=' + store.token)
		tasks.value = response.data
        allTasks.value = response.data
        console.log(tasks.value)

	} catch (error) {
		console.error('Error fetching data:', error)
	}
    filterTasks();
})

watch(search, () => {
    filterTasks();
});

const openNewTaskModal = () => {
    showAddModal.value = true;
    taskEdit = { id: null, title: "", description: "", expire_date: "" }; // Inicializar taskEdit para añadir una nueva tarea
}

const closeNewTaskModal = () => {
    showAddModal.value = false;
}

const openDeleteModal = (taskId, index) => {
    showDeleteModal.value = true;
    task.id = taskId;
    editingTaskIndex = index
}

const closeDeleteModal = () => {
    showDeleteModal.value = false;
}

const createNewTask = async () => {
    try {
        const response = await axios.post(url + '/new-task?token=' + store.token, taskEdit);
        tasks.value.push(response.data); // Asumo que el servidor devuelve la tarea creada
        allTasks.value.push(response.data); // Asumo que el servidor devuelve la tarea creada
        console.log('Tarea creada con éxito:', response.data);

        closeNewTaskModal(); // Cerrar el modal
    } catch (error) {
        console.error('Error al crear la tarea:', error);
    }
}

const openEditModal = (taskToEdit, index) => {
    taskEdit.id = taskToEdit.id;
    taskEdit.title = taskToEdit.title;
    taskEdit.description = taskToEdit.description;
    taskEdit.expire_date = taskToEdit.expire_date;
    editingTaskIndex.value = index;
    console.log(taskEdit)
    showEditModal.value = true;
}

const closeEditModal = async () => {
    showEditModal.value = false;
}

const saveEdit = async () => {
    // Guarda los cambios en el servidor
    try {
        await axios.put(url + "/update-task/" + taskEdit.id + "?token=" + store.token, taskEdit);
        console.log('Tarea actualizada con éxito en el servidor.');

        // Actualiza la tarea en la lista local y la lista backup
        const response = await axios.get(url + '/home?token=' + store.token)
		tasks.value = response.data
        allTasks.value = response.data

    } catch (error) {
        console.error('Error al actualizar la tarea:', error);
    }

    // Cierra el modal y reinicia el índice de edición y el objeto de edición
    closeEditModal();
    editingTaskIndex.value = null;
    taskEdit = {
        id: null,
        title: null,
        description: null,
        expire_date: null
    };
}

const deleteTask = async () => {
    try {
        // Elimina la tarea de la base de datos
        await axios.delete(`${url}/delete-task/${task.id}?token=${store.token}`);
        console.log('Tarea eliminada con éxito del servidor.');

        // Elimina la tarea de la lista local
        tasks.value.splice(editingTaskIndex, 1);
        tasks.value.splice(editingTaskIndex, 1);
        closeDeleteModal();
        editingTaskIndex = null;
        taskEdit = {
        id: null,
        title: null,
        description: null,
        expire_date: null
    };

    } catch (error) {
        console.error('Error al eliminar la tarea:', error);
    }
}

const taskComplete = async (taskComplete) => {
    task.completed = !task.completed;
    // Guarda los cambios en el servidor
    try {
        await axios.put(url + "/update-task/" + taskComplete.id + "?token=" + store.token, taskComplete);
        console.log('Tarea finalizada con éxito en el servidor.');

        // Actualiza la tarea en la lista local
        tasks.value[editingTaskIndex.value] = { ...taskEdit };

    } catch (error) {
        console.error('Error al actualizar la tarea:', error);
    }
}

const filterTasks = () => {
    if (search.value) {
        tasks.value = allTasks.value.filter(task => 
            task.title.includes(search.value) || 
            task.description.includes(search.value)
        );
    } else {
        tasks.value = [...allTasks.value];
    }
}


const showAllTasks = async () => {
    tasks.value = allTasks.value
}

const showToDoTasks = async () => {
    tasks.value = allTasks.value
    tasks.value = tasks.value.filter((task) => task.completed === false);
    console.log(tasks)
}

const showCompletedTasks = async () => {
    tasks.value = allTasks.value
    tasks.value = tasks.value.filter((task) => task.completed === true);
    console.log(tasks)
}
 
</script>
  