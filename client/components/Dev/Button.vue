<template>
    <Transition>
        <UButton v-if="!clicked" @click="callback">Submit</UButton>
        <UBadge v-else>Sent to message queue</UBadge>
    </Transition>
</template>

<script setup lang="ts">
const clicked = ref(false);
const props = defineProps(['callback']);

function buttonFunction() {
    clicked.value = true;
    props.callback();
    setTimeout(() => {
        clicked.value = false;
    }, 1000);
}
</script>