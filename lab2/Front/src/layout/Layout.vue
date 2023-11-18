<template class="min-h-screen">
  <Header></Header>
  <main class="flex flex-auto py-5 sm:py-10 min-h-[85vh] justify-center align-middle items-center">
    <router-view></router-view>
  </main>
  <Footer></Footer>
</template>

<script setup>
import Header from "../components/Header.vue";
import Footer from "../components/Footer.vue";
</script>
