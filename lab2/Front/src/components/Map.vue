<template>
    <div ref="mapElement" class="w-full h-full"></div>
  </template>
  
<script setup>
import { onMounted, ref, watch } from 'vue';
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
  
const props = defineProps({
  points: Object,
});
  
const mapElement = ref(null);
let map = null;
let markersLayer = L.layerGroup();


onMounted(() => {
  map = L.map(mapElement.value).setView([-35.675147, -71.542969], 4);
  L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap contributors'
  }).addTo(map);
  markersLayer.addTo(map);
});

watch(() => props.points, (newPoints, oldPoints) => {
  console.log(props.points);
  markersLayer.clearLayers();
  newPoints.list.forEach((point) => {
    L.marker([point.latitude, point.longitude], {title:point.fullname}).addTo(markersLayer).bindPopup(point.fullname);
  });
}, { deep: true });

</script>
  

