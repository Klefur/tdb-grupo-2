<template>
  <input
    :type="type"
    :placeholder="placeholder"
    :value="modelValue"
    class="w-full p-2 border rounded-md mb-4"
    @input="$emit('update:modelValue', $event.target.value)"
    required />
</template>

<script setup>
const props = defineProps({
  label: String,
  forLabel: String,
  type: String,
  placeholder: {
    type: String,
    required: false,
  },
  modelValue: String,
});
</script>
