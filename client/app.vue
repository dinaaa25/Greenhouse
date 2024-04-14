<template>
  <div>
    <NavigationBar />
    <NuxtPage />
  </div>
</template>

<script setup>
useHead({ htmlAttrs: { class: "h-full bg-gray-100" }, bodyAttrs: { class: "h-full" } });
</script>