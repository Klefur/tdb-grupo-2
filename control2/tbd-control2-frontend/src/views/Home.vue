<template>
    <div>
      <input v-model="search" placeholder="Buscar tarea..." />
      <button @click="createNewTask">Añadir Tarea</button>
  
      <div v-for="task in filteredTasks" :key="task.id">
        <TaskCard :task="task" @edit="editTask" @delete="deleteTask" @complete="markAsComplete" />
      </div>
    </div>
  </template>
  
  <script>
  import TaskCard from './TaskCard.vue';
  
  export default {
    components: {
      TaskCard
    },
    data() {
      return {
        tasks: [], // Lista de tareas obtenida desde la API
        search: '' // Palabra clave para filtrar tareas
      };
    },
    computed: {
      filteredTasks() {
        if (this.search) {
          return this.tasks.filter(task => task.title.includes(this.search) || task.description.includes(this.search));
        }
        return this.tasks;
      }
    },
    methods: {
      createNewTask() {
        // Lógica para crear una nueva tarea...
      },
      editTask(taskId) {
        // Lógica para editar una tarea...
      },
      deleteTask(taskId) {
        // Lógica para eliminar una tarea...
      },
      markAsComplete(taskId) {
        // Lógica para marcar una tarea como completada...
      }
    }
  };
  </script>
  