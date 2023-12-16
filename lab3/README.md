# Laboratorio 3 - Taller de Base de Datos/Bases de datos Avanzadas
## Este laboratorio fue desarrollado por el grupo n°2.
### Integrantes de grupo 2
* Diego Valdés
* Lucas Mesías
* Joaquín Saldivia
* Nicolás Aguilera
* Valentina Campos

# Herramientas de desarrollo

## Base de datos
* PgAdmin versión 4
* Visual Studio Code

## Backend
* IntelliJ IDEA Ultimate
* JDK versión 17
* Postman

# Guía de Instalación y Ejecución
Esta guía te ayudará a configurar tu entorno de desarrollo para trabajar con IntelliJ IDEA y MongoDB.

## 1. Clonar el repositorio

git clone https://github.com/Klefur/tdb-grupo-2.git

## 2. Instalación de IntelliJ IDEA

1. Descarga IntelliJ IDEA desde el sitio web oficial: [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

2. Instala IntelliJ IDEA siguiendo las instrucciones específicas para tu sistema operativo.

## 3. Instalación de MongoDB

1. Descarga MongoDB desde el sitio web oficial: [Descargar MongoDB](https://www.mongodb.com/try/download/community).

2. Sigue las instrucciones de instalación para tu sistema operativo.

3. Para verificar la instalación, abre una terminal y ejecuta `mongod --version` y `mongosh`.

## 4. Crear base de datos y cargar información

1. Abre una terminal, ve a la dirección /lab3 y ejecuta: 
```bash
mongosh < initLab3.js
```
2. Así ya tendrás creada la base de datos y se cargarán los datos de prueba.
   
## 5. Inicialización del proyecto por IntelliJ IDEA

1. Abre IntelliJ IDEA y abre el proyecto ubicado en lab3/Backend y presiona el botón de "Play" para ejecutar el proyecto.

¡Listo! Ya podrás ocupar la aplicación.
