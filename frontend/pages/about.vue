<template>
    <LayoutContainer>
        <div>
            <h1>Welcome to the about</h1>
        </div>
    </LayoutContainer>
</template>

<script setup lang="ts">
definePageMeta({
  middleware: ["authenticated-middleware"],
});
</script>

<style scoped>

</style>