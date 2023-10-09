<template>
    <button :type="type" @click="onClick" class="bg-orange-400 w-full text-white py-2 px-4 rounded-lg hover:bg-orange-500 focus:outline-none focus:ring focus:ring-blue-300">
          <a>{{ label }}</a>
        </button>
        <slot></slot>
</template>

<script setup>
    const props = defineProps({
        label: String,
        type: {
            type: String,
            required: false,
            default: 'button'
        },
        onClick:  {
            type: Function,
            required: false
        }
    })
</script>