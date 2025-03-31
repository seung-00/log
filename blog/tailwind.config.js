/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        "my": {
          "100": "#9299c8",
          "200": "#6d739d",
          "300": "#555f94",
          "400": "#434b79",
        },
        point: {
          accent: '#7f6df2',
        }
      }
    },
  },
  plugins: [
    require('@tailwindcss/typography')
  ],
}

