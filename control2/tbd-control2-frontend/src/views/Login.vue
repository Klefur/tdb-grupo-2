<template>
	<form class="m-auto grid xl:grid-cols-1 gap-10 p-10 min-w-[35%]">
		<div class="flex items-center justify-center">
  <div class="bg-white p-8 rounded-lg shadow-md w-80">
    <h2 class="text-2xl font-semibold mb-4">Iniciar Sesión</h2>
    <form>
      <Input Label="Usuario" forLabel="usuario" type="text" placeholder="Nombre de usuario" />
      <Input Label="Contrasena" forLabel="contrasena" type="password" placeholder="Contraseña" />
      <div class="flex flex-col gap-5 justify-between items-center mb-4">
        <button type="submit" class="bg-blue-500 w-full text-white py-2 px-4 rounded hover:bg-blue-600 focus:outline-none focus:ring focus:ring-blue-300">
          Ingresar
        </button>
        <a class="text-blue-500 hover:underline"><router-link to="/register"><p>¿No tienes una cuenta?</p></router-link></a>
      </div>
    </form>
  </div>
</div>

	</form>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref } from "vue";
import Input from "../components/Input.vue"

const router = useRouter()
const url = 'https://pindarosql.pindarousach.workers.dev'

const guestFunc = () => {
	router.push("/home")
}

const loginFunc = async () => {
	const data = {
		"email" : email.value,
		"password" : password.value
	}

    await axios.post(url + '/users/login', data)
    .then(response => {
        console.log('Respuesta del servidor:', response.data)
		const resp = response.data.payload.user[0]
        store.email = resp.email
        store.password = resp.password
        store.user = resp.name
        store.curso = resp.course
        router.push("/home")
    })
    .catch(error => {
        console.error('Error en la solicitud:', error)

    })
}
</script>
