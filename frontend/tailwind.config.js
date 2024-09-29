/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./components/**/*.{js,vue,ts}",
    "./layouts/**/*.vue",
    "./pages/**/*.vue",
    "./plugins/**/*.{js,ts}",
    "./nuxt.config.{js,ts}",
  ],
  theme: {
    extend: {
      colors: {
        white: {
          DEFAULT: "var(--white)",
        },
        black: {
          DEFAULT: "var(--black)",
        },
        "primary-dark": {
          DEFAULT: "var(--primary-dark)",
        },
        "primary-green": {
          DEFAULT: "var(--primary-green)",
          "50": "far(--primary-green-50)",
          "100": "far(--primary-green-100)",
        },
        "secondary-light": {
          DEFAULT: "var(--secondary-light)",
        },
        "card-color": {
          DEFAULT: "#F1F4EF"
        },
        gray: {
          DEFAULT: "var(--gray)",
          50: "var(--gray-50)",
          100: "var(--gray-100)",
          200: "var(--gray-200)",
        },
        red: {
          DEFAULT: "var(--red)",
        },
      },
    },
    fontFamily: {
      sans: ["Roboto", "ui-sans-serif"],
    },
  },
  plugins: [],
}