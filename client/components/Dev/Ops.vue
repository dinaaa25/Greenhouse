<template>
  <div>
    <NuxtLink to="/status">
      <UBadge v-if="status">All Systems Operational</UBadge>
      <UBadge v-else color="orange">Experiencing Problems</UBadge>
    </NuxtLink>
  </div>
</template>

<script setup lang="ts">
const { statuses } = useServiceStatus();

const status = computed(() => {
  if (statuses.value.length === 0) {
    return false;
  }

  for (let ser of statuses.value) {
    if (!ser.status) {
      return false;
    }
  }

  return true;
});
</script>