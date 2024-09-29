<template>
    <div class="flex flex-col items-stretch h-[100vh]">

        <div class="mb-10 grow">
            <slot />
        </div>
        <Footer class="h-min"/>
    </div>
</template>

<script setup lang="ts">

import Nav from "~/components/layout/Nav.vue";
</script>

<style scoped>

</style>