export default defineNuxtRouteMiddleware(async (to, from) => {
    const { $keycloak } = useNuxtApp();
    console.log($keycloak)
    if (!$keycloak.authenticated) {
        // $keycloak.login({ redirectUri: window.location.href });
        $keycloak.login();
    }
});