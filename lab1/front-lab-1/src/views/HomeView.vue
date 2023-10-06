<template>
	<div>
		<h1>Iniciar sesión</h1>
		<form @submit.prevent="login">
			<div>
				<label for="email">Correo electrónico:</label>
				<input type="email" id="email" v-model="email" required />
			</div>
			<div>
				<label for="password">Contraseña:</label>
				<input
					type="password"
					id="password"
					v-model="password"
					required
				/>
			</div>
			<button type="submit">Iniciar sesión</button>
		</form>
	</div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const email = ref("");
const password = ref("");
const token = ref("");
const router = useRouter();

const login = async () => {
	const response = await fetch("https://tu-api.com/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify({
			email: email.value,
			password: password.value,
		}),
	});

	if (response.ok) {
		const data = await response.json();
		token.value = data.token;
		localStorage.setItem("jwt", token.value);
		router.push("/home");
	} else {
		console.error("Error al iniciar sesión");
	}
};
</script>
