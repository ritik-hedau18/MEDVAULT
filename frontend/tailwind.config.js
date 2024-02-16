/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        dark: {
          900: '#020617',
          800: '#0F172A',
          700: '#1E293B',
          600: '#334155'
        },
        medvault: {
          primary: '#0EA5E9',
          success: '#10B981',
          teal: '#14B8A6',
          danger: '#EF4444'
        }
      }
    },
  },
  plugins: [],
}

// minor tweak: update verification rules and configs
