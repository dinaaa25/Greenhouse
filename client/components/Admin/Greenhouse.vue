<template>
  <div>
    <h2 class="text-xl my-4 inline-flex items-center gap-2">
      <Icon name="game-icons:greenhouse" /> Greenhouses
    </h2>
    <div class="border rounded shadow-sm">
      <UTable :columns="cols" :rows="ghouses" :empty-state="{ icon: 'i-heroicons-circle-stack-20-solid', label: 'No items.' }" />
    </div>
  </div>
</template>

<script setup lang="ts">
const ghouses = useState('greenhouses');

const cols = [
  {key: "id", label: "ID"},
  {key: "name", label: "Name"},
  {key: "description", label: "Description"},
];
</script>