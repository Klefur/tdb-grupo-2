<template>
  <header
    class="bg-sky-600 font-semibold text-2xl flex items-center p-1 px-60 h-[10vh] text-white">
    <div class="flex flex-row gap-5">
      <router-link to="/" class="mr-5"><p>Lab TBD</p></router-link>
      <router-link to="/">Login</router-link>|
      <router-link to="/register">Register</router-link>|
      <router-link to="/emergencias">Emergencias</router-link>
    </div>
  </header>
</template>

<script setup>
import { useRouter } from "vue-router";
</script>
