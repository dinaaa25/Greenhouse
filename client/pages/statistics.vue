<template>
  <div class="min-h-full">
    <main>
      <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
        <div class="mt-4">
          <h2 class="text-4xl mt-6 mb-5 text-gray-600 font-bold">{{ selectedGreenhouse.name }}</h2>
          <div class="grid grid-cols-3 gap-2 border-b pb-2">

            <div class="p-8 m-2 rounded-lg bg-red-400 shadow-md flex flex-col">
              <p class="text-white font-extrabold text-2xl">Humidity</p>
              <StatsIrrigation />
            </div>
            <div class="text-white p-8 m-2 rounded-lg bg-blue-400 shadow-md flex flex-col">
              <p class="font-extrabold text-2xl">Temperature</p>
              <StatsTemperature />
            </div>
            <div class="p-8 m-2 rounded-lg bg-blue-400 shadow-md flex flex-col">
              <p class="text-white font-extrabold text-2xl">Irrigation</p>
              <StatsIrrigation />
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
const greenhouses = useGreenhouses();
const selectedGreenhouse = useState("selected-greenhouse");
</script>