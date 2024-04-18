<template>
  <div class="min-h-full">
    <main class="">
      <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
        <div class="max-w-52">
          <p class="mb-2 font-medium">Select Greenhouse:</p>
          <USelectMenu v-model="selectedGreenhouse" :options="greenhouses" placeholder="Select Greenhouse" option-attribute="name" />
        </div>
        <div class="mt-4" v-if="selectedGreenhouse">
          <h2 class="text-4xl mt-6 mb-5 text-gray-600 font-bold">{{ selectedGreenhouse.name }}</h2>
          <UBadge>All systems operational</UBadge>
          <div class="grid grid-cols-3 gap-2 pb-2">
            <div class="bg-indigo-500 rounded-lg p-8 m-2 text-white">
              <p class="font-bold">Humidity Level</p>
              <p class="font-medium">This page contains all necessary information to keep an overview of your crops while we manage it automatically for you.</p>
            </div>
            <div class="text-white p-8 m-2 rounded-lg bg-blue-400 shadow-md flex flex-col">
              <p class="font-extrabold text-2xl">Temperature</p>
              <p class="font-medium font-mono text-4xl">{{temperature}}° Celsius</p>
              <p v-for="area of selectedGreenhouse.areas">Optimal temperature for <UBadge color="blue">{{ area?.crop?.name }}</UBadge> is between {{area?.crop?.minTemp}}-{{area?.crop?.maxTemp}} degrees.</p>
            </div>
            <div class="p-8 m-2 rounded-lg bg-blue-400 shadow-md flex flex-col row-span-2">
              <p class="text-white font-extrabold text-2xl">Irrigation</p>
              <Bar class="max-h-72" :data="chartData" :options="chartOptions" />
            </div>
            <div class="bg-blue-400 rounded-lg p-8 m-2 text-white">
              <p class="font-bold">Moisture Level</p>
            </div>
            <div class="p-8 m-2 rounded-lg border border-gray-200 bg-white text-gray-600 shadow-md flex flex-col">
              <div v-for="area in selectedGreenhouse.areas">
                <p class=" font-extrabold text-2xl">Current Crop: {{area.crop.name}}</p>
                <img class="h-32 place-self-end"
                  :src="area.crop.image" />
                </div>
            </div>
 
            <div class="text-white p-8 col-span-3 m-2 rounded-lg bg-indigo-400 shadow-md flex flex-col">
              <p class="font-extrabold text-2xl">Connected Devices</p>
              <ul class="space-y-2 my-2">
                <li class="bg-indigo-500 rounded px-2 py-1 flex items-center gap-2">
                  <div>
                    <Icon name="ph:fan-bold" /> Fan Extreme
                  </div>
                  <UBadge>active</UBadge>
                </li>
                <li class="bg-indigo-500 rounded px-2 py-1 flex items-center gap-2">
                  <div>
                    <Icon name="ph:fan-bold" /> Fan Extreme
                  </div>
                  <UBadge>active</UBadge>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="my-auto h-72 flex items-center justify-center">
          <Icon name="game-icons:greenhouse" class="text-gray-400" size="70" />
        </div>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { Bar } from 'vue-chartjs';
import type { Greenhouse } from '~/types/greenhouse';
import urls from "~~/urls.json";

const selectedGreenhouse = useState<Greenhouse>("selected-greenhouse");

const greenhouses = useGreenhouses();
const crops = useCrops();

const temperature = ref();

watch(selectedGreenhouse, async () => {
  if (selectedGreenhouse.value.id) {
    await $fetch(`${urls.temperature}/temperature/${selectedGreenhouse.value?.id}/current`, {async onResponse({request, response}) {
      if (response.status === 200) {
        temperature.value = await response._data;
      }
    }});
  }
});


const chartData = ref({
  labels: ['January', 'February', 'March', 'April', 'May'],
  datasets: [
    {
      label: 'Data One',
      backgroundColor: '#fff',
      data: [40, 20, 12, 50, 10],
    },
  ],
});

const chartOptions = ref({
  responsive: true,
  maintainAspectRatio: false,
});
</script>