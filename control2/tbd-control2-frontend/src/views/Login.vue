<template>
	<form class="m-auto grid xl:grid-cols-1 gap-10 p-10 min-w-[35%]">
		<div class="flex items-center justify-center">
  <div class="bg-white p-8 rounded-lg shadow-md w-80">
    <h2 class="text-2xl font-semibold mb-4">Iniciar Sesión</h2>
    <form>
      <Input Label="Usuario" forLabel="username" type="text" placeholder="Nombre de usuario" />
      <Input Label="Contrasena" forLabel="password" type="password" placeholder="Contraseña" />
      <div class="flex flex-col gap-5 justify-between items-center mb-4">
        <Boton :type="submit" label="Iniciar Sesión" href="/" @click="loginFunc()" class="bg-orange-400 hover:bg-orange-500"/>
        <a class="text-blue-500 hover:underline"><router-link to="/register"><p>¿No tienes una cuenta?</p></router-link></a>
      </div>
    </form>
  </div>
</div>

	</form>
</template>

<script setup>
import { useRouter } from "vue-router";
import { store } from "../store";
import axios from 'axios'
import { ref } from "vue";
import Input from "../components/Input.vue"
import Boton from "../components/Boton.vue"

const router = useRouter()
const url = 'http://localhost:8086'

const guestFunc = () => {
	router.push("/home")
}

const loginFunc = async () => {
	const data = {
		"username" : username.value,
		"password" : password.value
	}

    await axios.post(url + '/login', data)
    .then(response => {
      store.token = response.data
      console.log('Respuesta del servidor:', response.data)  
      router.push("/home")
    })
    .catch(error => {
        console.error('Error en la solicitud:', error)

    })
}
</script>
