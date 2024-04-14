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
          <span class="text-2xl font-bold">IoT simulator</span>
          <div class="grid grid-cols-3 gap-2 pb-2 mt-4">
            <div class="border rounded-lg p-5 space-y-2">
              <p>Enter New Inside Temperature</p>
              <URange v-model="temp" />
              <p>{{ temp }}</p>
              <UButton>Submit</UButton>
            </div>

            <div class="border rounded-lg p-5 space-y-2">
              <p>Humidity Sensor</p>
              <URange v-model="humidity" />
              <p>{{ humidity }}</p>
              <UButton>Submit</UButton>
            </div>


            <div class="border rounded-lg p-5 space-y-2">
              <p>Moisture Sensor</p>
              <URange v-model="moisture" />
              <p>{{ moisture }}</p>
              <UButton>Submit</UButton>
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


const temp = ref(50);
const humidity = ref(50);
const moisture = ref(50);


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