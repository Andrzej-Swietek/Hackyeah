<template>
    <div :class="className">
        <a
            v-for="link in navLinks"
            :key="link.id"
            :href="link.href"
            :class="{ 'mobile-link': isMobile, 'desktop-link': !isMobile }"
        >
            {{ link.name }}
        </a>
    </div>
</template>

<script setup lang="ts">
import { defineProps } from 'vue';

// Define props
const props = defineProps<{
    isMobile: boolean;
    class: string;
}>();

// Define navigation links
const navLinks = [
    { name: "Home", href: "/", id: 1 },
    { name: "Rooms", href: "/rooms", id: 2 },
    { name: "Contact", href: "/contact", id: 3 }
];
</script>

<style scoped>
.mobile-link {

}

.desktop-link {
    /* Desktop link styles */
}
</style>
