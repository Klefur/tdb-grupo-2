<template>
    <div class="flex flex-col w-[50%] bg-sky-200 p-4 rounded-lg">
        <div class="flex flex-row gap-5 w-full">
            <input v-model="search" class="rounded-lg" placeholder="Buscar tarea..." />
            <Boton label="+ Añadir Tarea" href="/" @click="createNewTask()" class="bg-orange-400 hover:bg-orange-500"/>
        </div>
      
      <Boton label="Ver Lista de Tareas" href="/" @click="showTasks()" class="bg-orange-400 hover:bg-orange-500"/>
  
      <div v-for="task in tasks" :key="task.id">
        <TaskCard :task="task" @edit="editTask" @delete="deleteTask" @complete="markAsComplete" />
      </div>
    </div>
  </template>
  
<script setup>
import { useRouter } from "vue-router";
import { store  } from "../store";
import axios from 'axios' 
import { ref } from "vue";
import Input from "../components/Input.vue"
import Boton from "../components/Boton.vue"

let tasks = []

const router = useRouter()
const url = 'http://localhost:8086'

const showTasks = async () => {

    await axios.get(url + '/home?token=' + store.token)
    .then(response => {
      tasks = response.data
      console.log('Respuesta del servidor:', response.data)
    })
    .catch(error => {
        console.error('Error en la solicitud:', error)

    })
}
 
</script>
  