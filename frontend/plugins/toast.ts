// plugins/vuetify.js
import Toast, { POSITION, PluginOptions } from "vue-toastification";

import "~/assets/css/variables/toast.scss";

export default defineNuxtPlugin(nuxtApp => {
    const options: PluginOptions = {
        maxToasts: 5,
        position: POSITION.BOTTOM_RIGHT
    }

    nuxtApp.vueApp.use(Toast, options)
})