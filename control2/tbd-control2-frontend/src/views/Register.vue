<template>
    <form class="m-auto grid xl:grid-cols-1 gap-10 p-10 min-w-[35%]">
		<div class="flex items-center justify-center">
  <div class="bg-white p-8 rounded-lg shadow-md w-80">
    <h2 class="text-2xl font-semibold mb-4">Registro de usuario</h2>
    <form>
      <Input Label="User" forLabel="username" @input="validateRegister" type="text" placeholder="Nombre de usuario" />
      <Input Label="Password" forLabel="password" @input="validateRegister" type="password" placeholder="Contraseña" />
	  <Input Label="Password2" forLabel="password2" @input="validateRegister" type="password" placeholder="Repita la Contraseña" />
      
        <p v-if="!isValidRegister" class="text-red-600 mb-2 text-center text-sm"> {{ errorMsg }} </p>
		<Boton label="Registrarse" @click="registerFunc()" :disabled="!isValidRegister" 
			:class="isValidRegister ? 
				'bg-orange-400 hover:bg-orange-500' :
				'bg-neutral-300 hover:cursor-default'"/>
    </form>
  </div>
</div>

	</form>
</template>

<script setup>
import { ref } from 'vue'
import Input from "../components/Input.vue"
import Boton from "../components/Boton.vue"
import axios from 'axios'
import { useRouter } from 'vue-router'
import { store } from '../store'

const url = 'http://localhost:8086'
const router = useRouter()
let isValidRegister = ref(false)
let errorMsg = ref("")

const validateRegister = () => {
	console.log('vl');
	if (username.value === "") {
		errorMsg.value = "Usuario no puede estar vacío"
		isValidRegister.value = false
		return
	}
	if (password.value !== password2.value) {
		console.log("pass")
		isValidRegister.value = false
		errorMsg.value = "Las contraseñas no coinciden"
		return
	}
	isValidRegister.value = true
}

const registerFunc = async () => {

	const data = {
		"username" : username.value,
		"password" : password.value
	}
	console.log(data)

    await axios.post(url + '/register', data)
    .then(response => {
        console.log('Respuesta del servidor:', response.data)
		router.push('/')
    })
    .catch(error => {
        console.error('Error en la solicitud:', error)
    });
}
</script>