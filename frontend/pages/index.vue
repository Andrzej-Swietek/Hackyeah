<template>
    <LayoutContainer>
        <div>
            <h1>Welcome to the homepage</h1>
            <div>
              <NuxtLink to="/about">  <div>About</div> </NuxtLink>
              <button @click="login">Login</button>
              <button @click="logout">Logout</button>
            </div>
        </div>
    </LayoutContainer>

</template>


<script setup lang="ts">
const { $keycloak } = useNuxtApp();

const login = () => {
  $keycloak.login();
};

const logout = () => {
  $keycloak.logout();
};
</script>