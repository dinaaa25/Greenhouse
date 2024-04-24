<template>
  <li class="border-b border-gray-200 pb-2 rounded px-2 py-1 flex items-center gap-2 justify-between" v-if="device">
    <div>
      <Icon :class="device.status ? 'animate-spin' : ''" :name="icon" /> {{ device.name }}

      <UBadge color="gray">{{ device.status }}</UBadge>
    </div>

    <UToggle v-model="device.status" />
  </li>
</template>

<script setup lang="ts">
import type { Device } from '~/types/device';

const props = defineProps<{
  device: Device
}>();

const icon = computed(() => {
  if (!props.device) {
    return;
  }

  if (props.device.type === "Fan") {
    return "ph:fan-bold";
  }
  if (props.device.type === "Heater") {
    return "lucide:heater";
  }
  if (props.device.type === "Rollup") {
    return "material-symbols:scrollable-header-outline-sharp";
  }
  if (props.device.type === "Valve") {
    return "material-symbols:valve-outline";
  }
  return "ph:fan-bold"
});
</script>