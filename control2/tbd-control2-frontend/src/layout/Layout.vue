<template class="min-h-screen flex">
    <Header></Header>
    <main class=" bg-sky-100 flex flex-auto py-5 sm:py-10 justify-center align-middle items-center">
        <router-view></router-view>
    </main>
    <Footer></Footer>
</template>

<script setup>
import Header from '../components/Header.vue';
import Footer from '../components/Footer.vue';
</script>
