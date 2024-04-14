<template>
  <div class="min-h-full">
    <main>
      <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
        <div class="max-w-52">
          <p class="mb-2 font-medium">Select Greenhouse:</p>
          <USelectMenu v-model="selected" :options="people" />
        </div>
        <div class="mt-4">
          <h2 class="text-4xl mt-6 mb-5 text-gray-600 font-bold">{{ selected }} Greenhouse</h2>
          <span>All systems operational</span>
          <div class="grid grid-cols-3 gap-2 pb-2">
            <div class="p-8 m-2 rounded-lg bg-red-400 shadow-md flex flex-col">
              <p class="text-white font-extrabold text-2xl">Current Crop: Paprika</p>
              <img class="h-32 place-self-end"
                src="https://static.vecteezy.com/system/resources/previews/022/024/733/original/vegetables-red-paprika-isolated-on-a-transparent-background-png.png" />
            </div>
            <div class="text-white p-8 m-2 rounded-lg bg-blue-400 shadow-md flex flex-col">
              <p class="font-extrabold text-2xl">Temperature</p>
              <p class="font-medium font-mono text-4xl">30° Celsius</p>
              <p>Optimal temperature for <UBadge>Paprika</UBadge> is between 20-40 degrees.</p>
            </div>
            <div class="p-8 m-2 rounded-lg bg-blue-400 shadow-md flex flex-col">
              <p class="text-white font-extrabold text-2xl">Irrigation</p>
              <Bar class="max-h-72" :data="chartData" :options="chartOptions" />
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
            <div class="bg-gray-300 rounded-lg p-8 m-2">Temperature</div>
            <div class="bg-gray-300 rounded-lg p-8 m-2">
              <p>Connected Devices</p>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { Bar } from 'vue-chartjs';
const people = ['Wade Cooper', 'Arlene Mccoy', 'Devon Webb', 'Tom Cook', 'Tanya Fox', 'Hellen Schmidt', 'Caroline Schultz', 'Mason Heaney', 'Claudie Smitham', 'Emil Schaefer']

const selected = ref(people[0]);

const chartData = ref({
  labels: ['January', 'February', 'March', 'April', 'May'],
  datasets: [
    {
      label: 'Data One',
      backgroundColor: '#fff',
      data: [40, 20, 12, 50, 10],
    },
  ],
})
const chartOptions = ref({
  responsive: true,
  maintainAspectRatio: false,
})
</script>