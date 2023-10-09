<template>
    <header class=" bg-sky-600 font-semibold text-2xl flex items-center p-1 px-10 h-16 text-white">
        <div class="flex flex-row">
            <button>
                <router-link to="/"><p>Control 2 TBD</p></router-link>
            </button>
        </div>
    </header>
</template>

<script setup>
import { useRouter } from 'vue-router'
const router = useRouter()
</script>
