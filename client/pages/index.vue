<template>
  <div class="min-h-full">
    <main class="">
      <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
        <div class="flex justify-between">
          <div class="max-w-52">
            <p class="mb-2 font-medium">Select Greenhouse:</p>
            <USelectMenu v-model="selectedGreenhouse" :options="greenhouses" placeholder="Select Greenhouse"
              option-attribute="name" />
          </div>
          <DevOps />
        </div>
        <div class="mt-4" v-if="selectedGreenhouse">
          <h2 class="text-4xl mt-6 mb-5 text-gray-800 font-bold">{{ selectedGreenhouse.name }}</h2>
          <div class="grid grid-cols-3 gap-2 pb-2">
            <div class="bg-white rounded-lg p-8 m-2 shadow">
              <p class="font-bold text-gray-600 text-2xl">Humidity Level</p>
              <p class="font-bold font-mono text-2xl mt-4 text-gray-500">33.2 g/m<sup>3</sup></p>
            </div>
            <div class="text-gray-500 p-8 m-2 gap-2 rounded-lg bg-white shadow flex flex-col">
              <p class="font-bold text-gray-600 text-2xl">Temperature</p>
              <p class="font-bold font-mono text-2xl">{{ selectedGreenhouse.temperature }}° Celsius</p>
              <p v-for="area of selectedGreenhouse.areas">Optimal temperature for <UBadge color="blue">{{
              area?.crop?.name }}</UBadge> is between {{ area?.crop?.minTemp }}-{{ area?.crop?.maxTemp }} degrees.
              </p>
            </div>
            <div class="p-8 m-2 rounded-lg bg-white shadow flex flex-col row-span-2">
              <p class="text-gray-600 font-bold text-2xl">Irrigation</p>
              <Bar class="max-h-72" :data="chartData" :options="chartOptions" />
            </div>
            <div class="bg-white rounded-lg p-8 m-2 text-gray-500 shadow">
              <p class="font-bold text-2xl text-gray-600 mb-2">Moisture Level</p>
              <p class="font-bold font-mono text-2xl">40 %</p>
            </div>
            <div class="p-8 m-2 rounded-lg bg-white text-gray-600 shadow flex flex-col">
              <div v-for="area in selectedGreenhouse.areas">
                <p class="text-gray-600 font-bold text-2xl mb-2">Current Crop: {{ area.crop.name }}</p>
                <img class="h-32 place-self-end" :src="area.crop.image" />
              </div>
            </div>

            <div class="text-gray-500 p-8 col-span-3 m-2 rounded-lg bg-white shadow flex flex-col">
              <p class="font-extrabold text-gray-600 text-2xl">Connected Devices</p>
              <ul class="space-y-4 my-2">
                <DashboardDevice v-for="device in selectedGreenhouse.devices" :device="device" />
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

watch(selectedGreenhouse, async () => {
  if (selectedGreenhouse.value.id) {
    await $fetch(`${urls.temperature}/temperature/${selectedGreenhouse.value?.id}/current`, {
      async onResponse({ request, response }) {
        if (response.status === 200) {
          const green = greenhouses.value.find(e => e.id === selectedGreenhouse.value.id);
          green!.temperature = await response._data;
        }
      }
    });
  }
});

const irrigationData = computed(() => {
  return Array.from(Array(5)).map(e => Math.random() * 10);
});


const chartData = ref({
  labels: ['January', 'February', 'March', 'April', 'May'],
  datasets: [
    {
      label: 'Data One',
      backgroundColor: '#0EA5E9',
      data: irrigationData.value,
    },
  ],
});

const chartOptions = ref({
  responsive: true,
  maintainAspectRatio: false,
});
</script>