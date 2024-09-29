import Keycloak from "keycloak-js";
import { omit } from "remeda";


export default defineNuxtPlugin((nuxtApp) => {
    const config = useRuntimeConfig();
    const keycloak = new Keycloak({
        url: config.public.keycloakUrl,      // Keycloak URL
        realm: config.public.keycloakRealm,  // Keycloak Realm
        clientId: config.public.keycloakClientId,             // Keycloak Client ID
    });

    console.log(config.public)

    keycloak.init({ onLoad: 'check-sso' }).then((authenticated) => {
        if (!authenticated) {
            console.log('User not authenticated');
        }
    }).catch((error) => {
        console.error('Keycloak initialization error:', error);
    });

    return {
        provide: {
            keycloak,
        },
    };
});