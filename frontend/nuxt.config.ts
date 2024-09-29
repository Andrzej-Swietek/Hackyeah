// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  target: 'static',
  ssr: false,
  compatibilityDate: '2024-04-03',
  devtools: { enabled: true },
  runtimeConfig: {
    public: {
      API_URL: process.env.API_URL,
      BACKEND_URL: process.env.BACKEND_URL,
      keycloakUrl: process.env.KEYCLOAK_URL,
      keycloakRealm: process.env.KEYCLOAK_REALM,
      keycloakClientId: process.env.KEYCLOAK_CLIENT_ID,
    },
  },
  routeRules: {
    '/': { prerender: true },
  },
  buildModules: [
    "@nuxt/typescript-build",
    "@nuxtjs/tinymce",
    '@nuxtjs/moment',
  ],
  modules: [
    "@nuxtjs/tailwindcss",
    "@pinia/nuxt",
    '@pinia-plugin-persistedstate/nuxt',
    '@ant-design-vue/nuxt',
    '@vueuse/nuxt',
    "nuxt-lodash",
  ],
  css: [
    "~/assets/css/main.scss",
    "vuetify/lib/styles/main.sass",
    "@mdi/font/css/materialdesignicons.css"
  ],
  app: {
    head: {
      viewport: "width=device-width, initial-scale=1",

      // FONTS AND CDNs
      link: [
        // FONTS:
        {
          rel: "stylesheet",
          href: "https://fonts.googleapis.com/css2?family=Playfair+Display&family=Roboto:wght@300;400;500;700&family=Work+Sans:wght@300;400;500;600;700&display=swap",
        },

        // CDN
      ],

      // JS SCRIPTS
      script: []
    }
  }, // END app


  build: {
    transpile: ["vuetify"],
  },
  extractCss: true,
  vuetify: {
    customVariables: ["~/assets/css/variables/vuetify.scss"],
    treeShake: true
  },

  // TAILWIND
  postcss: {
    plugins: {
      tailwindcss: {},
      autoprefixer: {},
    },
  },

})
