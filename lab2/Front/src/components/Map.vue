<template>
    <div ref="mapContainer" style="height: 500px; width: 500px;"></div>
  </template>
  
<script setup>
  import { onMounted, ref, watchEffect } from 'vue';
  import L from 'leaflet';
  import 'leaflet/dist/leaflet.css';
  
  const props = defineProps({
    points: Array,
  });
  
  const mapContainer = ref(null);
  let map;

  onMounted(() => {
    map = L.map(mapContainer.value).setView([0, 0], 1);
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: '© OpenStreetMap contributors'
    }).addTo(map);

    console.log(props.points);

    props.points.forEach(point => {
      L.marker([point.latitud, point.longitud]).addTo(map)
        .bindPopup('Un punto de interés');
      console.log(point.latitud, point.longitud);
    });
  
    if (props.points.length) {
      const group = L.featureGroup(props.points.map(point => L.marker([point.latitud, point.longitud])));
      map.fitBounds(group.getBounds());
    }
  });

</script>
  