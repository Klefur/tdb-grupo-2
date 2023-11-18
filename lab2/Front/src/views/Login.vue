<template>
	<form
		class="m-auto flex gap-10 p-10 min-w-[35%] items-center justify-center"
	>
		<div class="bg-white p-8 rounded-lg shadow-md w-80">
			<h2 class="text-2xl font-semibold mb-4">Iniciar Sesión</h2>
			<fieldset>
				<Input
					Label="Username"
					type="text"
					placeholder="Nombre de usuario"
					v-model="username"
				/>
				<Input
					Label="Password"
					type="password"
					placeholder="Contraseña"
					v-model="password"
				/>
				<div
					class="flex flex-col gap-5 justify-between items-center mb-4"
				>
					<Boton
						@click="loginFunc"
						type="submit"
						label="Ingresar"
					></Boton>
					<a class="text-blue-500 hover:underline"
						><router-link to="/register"
							><p>¿No tienes una cuenta?</p></router-link
						></a
					>
				</div>
			</fieldset>
		</div>
	</form>
</template>

<script setup>
import { useRouter } from "vue-router";
import { store } from "../store";
import axios from "axios";
import { ref } from "vue";
import Input from "../components/Input.vue";
import Boton from "../components/Boton.vue";

const router = useRouter();
const url = "http://localhost:3000";

const username = ref("");
const password = ref("");

const loginFunc = async () => {
	const data = {
		username: username.value,
		password: password.value,
	};
	console.log(data);

	await axios
		.post(url + "/login", data)
		.then((response) => {
			store.token = response.data;
			console.log(response);
			console.log(response.data);
			router.push("/emergencias");
		})
		.catch((error) => {
			console.error("Error en la solicitud:", error);
		});
};
</script>
