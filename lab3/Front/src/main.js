import { createApp } from "vue";
import router from "../../Front/src/router";
import "./style.css";
import App from "./App.vue";

createApp(App).use(router).mount("#app");
