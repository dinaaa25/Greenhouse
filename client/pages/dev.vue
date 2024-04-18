<template>
  <div class="min-h-full">
    <main>
      <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
        <div class="mt-4" v-if="selectedGreenhouse">
          <h2 class="text-4xl mt-6 mb-5 text-gray-600 font-bold">{{ selectedGreenhouse.name }} Greenhouse</h2>
          <span class="text-2xl font-bold">IoT simulator</span>
          <div class="grid grid-cols-3 gap-2 pb-2 mt-4">
            <div class="border rounded-lg p-5 space-y-2">
              <p>Enter New Inside Temperature</p>
              <URange v-model="temp" />
              <p>{{ temp }}</p>
              <DevButton :callback="submitTemperature">Submit</DevButton>
            </div>

            <div class="border rounded-lg p-5 space-y-2">
              <p>Humidity Sensor</p>
              <URange v-model="humidity" />
              <p>{{ humidity }}</p>
              <DevButton>Submit</DevButton>
            </div>


            <div class="border rounded-lg p-5 space-y-2">
              <p>Moisture Sensor</p>
              <URange v-model="moisture" />
              <p>{{ moisture }}</p>
              <DevButton>Submit</DevButton>
            </div>
          </div>
        </div>
        <div v-else>
        select a greenhouse first.
        </div>
      </div>

    </main>
  </div>
</template>

<script setup lang="ts">
import type { Greenhouse } from '~/types/greenhouse';
import type { TemperatureMeasurement } from '~/types/temperature';

const greenhouses = useGreenhouses();
const selectedGreenhouse = useState<Greenhouse>("selected-greenhouse");


const temp = ref(50);
const humidity = ref(50);
const moisture = ref(50);

const myclient = useStompClient();

async function submitTemperature() {
  if (temp.value && selectedGreenhouse.value.id) {
    sendTemperatureToMessageQueue(temp.value, selectedGreenhouse.value.id);
  }
}

function sendTemperatureToMessageQueue(temperature: number, greenhouseId: number) {
  const date = new Date();
  const body: TemperatureMeasurement = {"insideTemp": temperature, "greenhouseId": greenhouseId, "measuredDateTime": date.toISOString()};
  myclient.publish({destination: "temperature_measurment", headers: {"_typeId": "com.botanic.temperature.model.TemperatureMeasurement"}, body: JSON.stringify(body)});
}
</script>