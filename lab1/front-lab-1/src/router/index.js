import { createRouter, createWebHashHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
	{
		path: "/",
		name: "home",
		component: HomeView,
	},
	{
		path: "/emergencias",
		name: "emergencias",
		component: () => import("../views/ListaEmergencias.vue"),
	},
];

const router = createRouter({
	history: createWebHashHistory(),
	routes,
});

export default router;
