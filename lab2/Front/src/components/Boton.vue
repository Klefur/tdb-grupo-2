<template>
	<button @click="handleClick" :class="btnClass" :type="type">
		<a>{{ label }}</a>
		<slot></slot>
	</button>
</template>

<script setup>
import { defineProps, defineEmits } from "vue";

const props = defineProps({
	label: {
		type: String,
		default: "",
	},
	type: {
		type: String,
		default: "button",
	},
	btnClass: {
		type: String,
		default:
			"bg-orange-400 w-full text-white py-2 px-4 rounded-lg hover:bg-orange-500 focus:outline-none focus:ring focus:ring-blue-300",
	},
});

const emit = defineEmits(["click"]);

const handleClick = (event) => {
	emit("click", event);
};
</script>
