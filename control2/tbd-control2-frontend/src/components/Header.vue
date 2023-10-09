<template>
    <header class=" bg-sky-600 font-semibold text-2xl flex items-center justify-center p-1 h-16 text-white">
        <div class="flex flex-row w-[80%]">
            <button>
                <router-link to="/"><p>SAT - Sistema de Administración de Tareas</p></router-link>
            </button>
        </div>
    </header>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
</script>
