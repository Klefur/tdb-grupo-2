/** @type {import('tailwindcss').Config} */
module.exports = {
    enabled: process.env.NODE_ENV === 'production',
    content: [
      './src/**/*.vue',
      './src/**/*.js',
      './public/index.html',
    ],
  // ... el resto de tu configuración
}


