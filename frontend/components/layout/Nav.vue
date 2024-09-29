<template>
  <nav class="relative mx-8 mb-24 mb-[45px] flex items-center justify-between pb-6 pt-12 font-medium md:mx-16 lg:mx-32">
    <!-- SVG Divider -->
    <svg
        class="absolute bottom-0 left-1/2 -translate-x-1/2"
        width="250"
        height="4"
        viewBox="0 0 250 4"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
    >
      <path
          class="animate-path"
          d="M2 2L428 1.99996"
          stroke="#282828"
          stroke-width="2"
          stroke-linecap="round"
      />
    </svg>

    <!-- Center Logo -->
    <div class="text-lg font-bold absolute left-1/2 -translate-x-1/2">
      <a href="/">
        <img class="h-[50px]" :src="logo" alt="AGMAREH logo" loading="eager" decoding="async" />
      </a>
    </div>

    <!-- Right Section (Auth Buttons) -->
    <div class="flex items-center gap-4">
      <!-- Show Login/Register when user is not logged in -->
      <div v-if="!isLoggedIn" class="flex gap-4">
        <button @click="login" class="btn-secondary">Login</button>
        <button @click="register" class="btn-primary">Register</button>
      </div>

      <!-- Show Sign Out when user is logged in -->
      <button v-else @click="logout" class="btn-primary">Sign Out</button>

      <!-- Hamburger Toggle for Mobile -->
      <div
          @click="toggleNav"
          class="burger z-50 cursor-pointer space-y-1.5 xl:hidden"
      >
        <span :class="['block h-0.5 w-8 bg-black', { 'rotate-45 translate-y-2': toggled.value }]" />
        <span :class="['block h-0.5 w-6 bg-black', { 'w-0': toggled.value }]" />
        <span :class="['block h-0.5 w-4 bg-black', { 'rotate-[-45deg] translate-y-[-2px] w-8': toggled.value }]" />
      </div>
    </div>

    <!-- Mobile Nav Items -->
    <div v-if="toggled.value" class="fixed left-0 top-0 z-40 flex h-[100vh] w-full flex-col items-center justify-center gap-24 bg-white text-2xl font-bold">
      <NavLinks :isMobile="true" class="flex flex-col gap-24 text-lg" />

      <!-- Mobile Auth Buttons -->
      <div v-if="!isLoggedIn" class="flex flex-col gap-4">
        <button @click="goToLogin" class="btn-secondary">Login</button>
        <button @click="goToRegister" class="btn-primary">Register</button>
      </div>

      <!-- Show Sign Out in mobile when logged in -->
      <button v-else @click="handleLogout" class="btn-primary">Sign Out</button>
    </div>
  </nav>
</template>

<script setup lang="ts">
import { ref, watch, defineProps, computed } from 'vue';
import NavLinks from './NavLinks.vue';
import useUserStore from '~/store/user'; // Adjust the import path if needed


// Define props for the logo and name passed to the component
const props = defineProps<{
  logo: string;
  name: string;
}>();

// Ref for toggling mobile navigation
const toggled = ref(false);

// Access the user store for user data
const userStore = useUserStore();

// Check if the user is logged in based on whether their email is present
const isLoggedIn = computed(() => userStore.userId != null);

// Watch the toggled state and adjust body overflow when the mobile menu is active
watch(toggled, (newVal) => {
  document.body.style.overflow = newVal ? 'hidden' : 'auto';
});

// Toggle mobile navigation
const toggleNav = () => {
  toggled.value = !toggled.value;
};

// Access the Keycloak instance from the Nuxt app
const { $keycloak } = useNuxtApp();

// Keycloak login method
const login = async () => {
  try {
    await $keycloak.login(); // Perform the login
    const userId = $keycloak.tokenParsed?.sub; // Get user ID (Keycloak uses `sub` as the user identifier)

    // Save only the user ID to the store after successful login
    saveUserIdToStore(userId);
  } catch (error) {
    console.error('Login failed:', error);
  }
};

// Keycloak logout method
const logout = async () => {
  try {
    await $keycloak.logout(); // Perform logout
    // Remove the user and token from the store after logout
    removeUserAndToken();
  } catch (error) {
    console.error('Logout failed:', error);
  }
};

// Register logic (if you want to redirect to Keycloak's registration page)
const register = async () => {
  try {
    await $keycloak.login({ action: 'register' }); // Redirect to registration page
    const userId = $keycloak.tokenParsed?.sub; // Get user ID after successful registration

    // Save only the user ID to the store after registration
    saveUserIdToStore(userId);
  } catch (error) {
    console.error('Registration failed:', error);
  }
};
</script>



<style scoped>
.burger span {
  transition: all 0.3s ease;
}

.burger span.rotate-45 {
  transform: rotate(45deg);
}

.burger span.rotate--45deg {
  transform: rotate(-45deg);
}

.btn-primary, .btn-secondary {
  padding: 10px 20px;
  border-radius: 5px;
  font-size: 1rem;
}

.btn-primary {
  background-color: #1877F2;
  color: white;
}

.btn-secondary {
  background-color: transparent;
  border: 1px solid #1877F2;
  color: #1877F2;
}

.btn-primary:hover, .btn-secondary:hover {
  opacity: 0.8;
}

nav {
  position: relative;
  z-index: 10;
}

.flex.items-center.gap-4 {
  position: absolute;
  right: 0; /* Move buttons to the right */
  top: 12px; /* Align buttons to the top */
}
</style>
