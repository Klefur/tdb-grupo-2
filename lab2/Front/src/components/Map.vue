<template>
	<div ref="mapElement" class="w-full h-full"></div>
</template>

<script setup>
import { onMounted, ref, watch } from "vue";
import L from "leaflet";
import "leaflet/dist/leaflet.css";

const props = defineProps({
	points: Object,
});

const mapElement = ref(null);
let map = null;
let markersLayer = L.layerGroup();

function getZoom(radius) {
	return 15.7 + -0.000217 * radius + 0.00000000141 * radius ** 2;
}

onMounted(() => {
	// Inicia centrado en chile
	map = L.map(mapElement.value).setView([-35.675147, -71.542969], 4);
	L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
		attribution: "© OpenStreetMap contributors",
	}).addTo(map);
	markersLayer.addTo(map);

	// Crea un control personalizado con un botón para restablecer la vista del mapa
	var homeControl = L.control({ position: "topleft" });

	homeControl.onAdd = function (map) {
		var controlDiv = L.DomUtil.create(
			"div",
			"leaflet-bar leaflet-control leaflet-control-custom",
		);

		controlDiv.style.backgroundColor = "white";
		controlDiv.style.backgroundImage =
			"url('https://img.icons8.com/material-rounded/24/home.png')";
		controlDiv.style.backgroundSize = "30px 30px";
		controlDiv.style.width = "34px";
		controlDiv.style.height = "34px";

		controlDiv.onclick = function () {
			let em = props.points.emergency;
			map.setView(
				[em.latitude, em.longitude],
				getZoom(props.points.radius),
			);
		};

		return controlDiv;
	};

	homeControl.addTo(map);
});

watch(
	() => props.points,
	(newPoints, oldPoints) => {
		console.log(props.points);
		markersLayer.clearLayers();

		newPoints.list.forEach((point) => {
			L.marker([point.latitude, point.longitude], {
				title: point.fullname,
			})
				.addTo(markersLayer)
				.bindPopup(point.fullname);
		});

		let em = newPoints.emergency;

		var greenIcon = new L.Icon({
			iconUrl:
				"https://raw.githubusercontent.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png",
			shadowUrl:
				"https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
			iconSize: [25, 41],
			iconAnchor: [12, 41],
			popupAnchor: [1, -34],
			shadowSize: [41, 41],
		});

		L.marker([em.latitude, em.longitude], {
			title: "Emergencia",
			icon: greenIcon,
		})
			.addTo(markersLayer)
			.bindPopup(`<b>${em.name}</b><br>${em.description}`);
		L.circle([em.latitude, em.longitude], {
			color: "red",
			fillColor: "#f03",
			fillOpacity: 0.1,
			radius: newPoints.radius,
		}).addTo(markersLayer);

		map.setView([em.latitude, em.longitude], getZoom(newPoints.radius));
	},
	{ deep: true },
);
</script>
