import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

import {mdi} from "vuetify/lib/iconsets/mdi";
import { aliases } from 'vuetify/iconsets/mdi'

export default defineNuxtPlugin(nuxtApp => {
    const vuetify = createVuetify({
        ssr: false,
        components,
        directives,
        icons: {
            defaultSet: 'mdi',
            aliases,
            sets: {
                mdi
            },
        },
        theme: {
            defaultTheme: 'light',
            themes: {
                light: {
                    dark: false,
                    colors: {
                        white: '#ffffff',
                        black: '#000000',
                        primary_dark: '#303330',
                        primary_green_50: '#F1F4EF',
                        primary_green: '#649120',
                        secondary_green: '#173637',
                        secondary_light: '#296062',
                        gray: '#757975',
                        gray_50: '#C6CAC5',
                        gray_100: '#5D625D',
                        gray_200: '#4C4E4D',
                        red: '#B3261E',
                    }
                },
            },
        },
    })

    nuxtApp.vueApp.use(vuetify)
})