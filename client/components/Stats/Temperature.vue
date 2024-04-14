<template>
  <Line class="max-h-72" :data="chartData" :options="chartOptions" />
</template>

<script setup lang="ts">
import { Line } from 'vue-chartjs';

const chartData = ref({
  labels: [1, 2, 3, 4, 5, 6, 7],
  datasets: [
    {
      label: 'My First Dataset',
      data: [20, 22, 20, 19, 25, 25, 25],
      fill: false,
      borderColor: 'rgb(256, 256, 256)',
      tension: 0.1
    },
  ],
});

const chartOptions = ref({
  responsive: true,
  maintainAspectRatio: false,
}); 
</script>