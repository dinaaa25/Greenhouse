<template>
  <div>
    <h2 class="text-xl my-4 inline-flex items-center gap-2">
      <Icon name="ph:fan-bold" /> Devices
    </h2>
    <div class="border rounded shadow-sm">
      <UTable :rows="devices" :empty-state="{ icon: 'i-heroicons-circle-stack-20-solid', label: 'No items.' }" />
    </div>
  </div>
</template>

<script setup lang="ts">
interface Device {
  id: number,
  name: string,
  description: string,
  type: string,
  status: string,
}

const devices: Device[] = useState("all-devices");

useFetch("http://localhost:8000/devices/device", {
  async onResponse({ request, response }) {
    if (response.status === 200) {
      devices.value = await response._data;
    }
  }
});
</script>