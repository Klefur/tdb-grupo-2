<template>
    <div class="mb-4">
        <label for="username" class="block text-gray-600"></label>
        <input :type="type" :id="forLabel" :placeholder="placeholder" class="w-full p-2 border rounded-md" required />
      </div>
</template>

<script setup>
    const props = defineProps({
        label: String,
        forLabel: String,
        type: String,
        placeholder:  {
            type: String,
            required: false
        }
    })
</script>