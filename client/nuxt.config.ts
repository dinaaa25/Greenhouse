// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  devtools: { enabled: true },
  ssr: false,
  modules: ["nuxt-icon", "@nuxt/ui"],
  colorMode: {
    preference: "light",
  },
});
