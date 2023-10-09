<template>
    <div class="border p-4 rounded-md shadow-md hover:shadow-lg transition-shadow duration-200">
      <h3 class="text-xl mb-2">{{ task.title }}</h3>
      <p class="mb-4">{{ task.description }}</p>
      <p class="text-sm text-gray-500 mb-2">Fecha de vencimiento: {{ jaja}}</p>
      <div class="flex justify-between items-center">
        <button @click="emitEdit" class="text-blue-500 hover:underline">Editar</button>
        <button @click="emitDelete" class="text-red-500 hover:underline">Eliminar</button>
        <input type="checkbox" v-model="task.completed" @change="emitComplete">
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      task: {
        type: Object,
        required: true
      }
    },
    methods: {
      emitEdit() {
        this.$emit('edit', this.task.id);
      },
      emitDelete() {
        this.$emit('delete', this.task.id);
      },
      emitComplete() {
        this.$emit('complete', this.task.id);
      }
    }
  };
  </script>
  