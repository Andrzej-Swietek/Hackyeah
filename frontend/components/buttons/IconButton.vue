<template>
    <component
        :is="href ? 'router-link' : 'div'"
        :to="href"
        :class="[styles, iconSize, 'aspect-square cursor-pointer']"
        @click="onClick"
    >
        <img :src="icon || ''" alt="hero icon" :width="100" :height="100" />
    </component>
</template>

<script setup>
import { defineProps, computed } from 'vue';

// Define props
const props = defineProps({
    icon: { type: String, required: true },
    iconSize: { type: String, default: '' },
    onClick: { type: Function, default: () => {} },
    styles: { type: String, default: '' },
    href: { type: String, default: '' }
});
</script>

<style scoped>
.aspect-square {
    aspect-ratio: 1 / 1;
}
.cursor-pointer {
    cursor: pointer;
}
</style>
