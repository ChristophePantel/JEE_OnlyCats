module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      colors: {
        modal: "rgba(0 ,0 ,0 , 0.3)"
      }
    },
  },
  plugins: [require("@tailwindcss/forms")],
}
