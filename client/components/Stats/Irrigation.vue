<template>
  <Bar class="max-h-72" :data="chartData" :options="chartOptions" />
</template>

<script setup lang="ts">
import { Bar } from 'vue-chartjs';


const chartData = ref({
  labels: ['January', 'February', 'March', 'April', 'May'],
  datasets: [
    {
      label: 'Data One',
      backgroundColor: '#0EA5E9',
      data: [10, 20, 25, 30, 35],
    },
  ],
});

const chartOptions = ref({
  responsive: true,
  maintainAspectRatio: false,
}); 
</script>