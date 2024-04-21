<template>
  <div class="mx-auto max-w-7xl my-10">
    <h1 class="text-3xl mb-8">Microservice Health Check</h1>
    <UBadge color="gray">{{ total
      }} / {{
      statuses.length }}</UBadge>
    <div class="border-b my-4"></div>
    <div class="space-y-4">
      <div v-for="status in statuses" class="flex gap-2">
        <span class="font-medium text-gray-600">{{ status.name }}</span>
        <UBadge v-if="!status.status" color="red">Down</UBadge>
        <UBadge v-else>Up</UBadge>
        <a :href="status.link" class="underline text-blue-500">link</a>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
const statuses = useServiceStatus();

const total = computed(() => {
  let result = 0;
  if (statuses.value.length === 0) {
    return 0;
  }
  for (let i of statuses.value) {
    if (i.status) {
      result++;
    }
  }
  return result;
});
</script>