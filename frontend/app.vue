<template>
    <NuxtLayout>
        <NuxtPage />
    </NuxtLayout>
</template>

<script setup lang="ts">
import { getAuthenticatedUser } from './helpers/auth';

onBeforeMount(() => {
    getAuthenticatedUser();
})

</script>