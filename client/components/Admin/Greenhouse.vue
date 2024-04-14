<template>
  <div>
    <h2 class="text-xl my-4 inline-flex items-center gap-2">
      <Icon name="game-icons:greenhouse" /> Greenhouses
    </h2>
    <div class="border rounded shadow-sm">
      <UTable :rows="ghouses" :empty-state="{ icon: 'i-heroicons-circle-stack-20-solid', label: 'No items.' }" />
    </div>
  </div>
</template>

<script setup lang="ts">
interface Greenhouse {
  id: number,
  name: string,
  description: string,
}


const ghouses: Greenhouse[] = [];

</script>