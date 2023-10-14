<template>
  <form class="flex m-auto gap-10 p-10 min-w-[35%] items-center justify-center">
      <div class="bg-white p-8 rounded-lg shadow-md w-80">
        <h2 class="text-2xl font-semibold mb-4">Registro de usuario</h2>
        <fieldset>
          <Input
            Label="Username"
            @input="validateRegister"
            type="text"
            placeholder="Nombre de usuario"
            v-model="username"
          />
          <Input
            Label="Password"
            @input="validateRegister"
            type="password"
            placeholder="Contraseña"
            v-model="password"
          />
          <Input
            Label="Password2"
            @input="validateRegister"
            type="password"
            placeholder="Repita la Contraseña"
            v-model="password2"
          />

          <p
            v-if="!isValidRegister"
            class="text-red-600 mb-2 text-center text-sm"
          >
            {{ errorMsg }}
          </p>
          <Boton
            label="Registrarse"
            @click="registerFunc()"
            :disabled="!isValidRegister"
            :class="
              isValidRegister
                ? 'bg-orange-400 hover:bg-orange-500'
                : 'bg-neutral-300 hover:cursor-default'
            "
          />
        </fieldset>
      </div>
  </form>
</template>

<script setup>
import { ref } from "vue";
import Input from "../components/Input.vue";
import Boton from "../components/Boton.vue";
import axios from "axios";
import { useRouter } from "vue-router";

const url = "http://localhost:3000";
const router = useRouter();
let isValidRegister = ref(false);
let errorMsg = ref("");
let username = ref("");
let password = ref("");
let password2 = ref("");

const validateRegister = () => {
  console.log("vl");
  if (username.value === "") {
    errorMsg.value = "Correo no puede estar vacío";
    isValidRegister.value = false;
    return;
  }
  if (password.value !== password2.value) {
    console.log("pass");
    isValidRegister.value = false;
    errorMsg.value = "Las contraseñas no coinciden";
    return;
  }
  isValidRegister.value = true;
};

const registerFunc = async () => {
  const data = {
    username: username.value,
    password: password.value,
  };
  console.log(data);

  await axios
    .post(url + "/register", data)
    .then((response) => {
      localStorage.setItem("token", response.data);
      console.log("Respuesta del servidor:", response.data);
      router.push("/home");
    })
    .catch((error) => {
      console.error("Error en la solicitud:", error);
    });
};
</script>
