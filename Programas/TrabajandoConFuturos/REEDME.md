# README del Proyecto

## Descripción

Este proyecto en Java se centra en la descarga de varias páginas web y su almacenamiento en archivos individuales en un directorio específico. Posteriormente, comprime todos los archivos en ese directorio en un solo archivo .ZIP.

## Requisitos

- Java 11 o superior
- Maven

## Estructura del Proyecto

El proyecto sigue la estructura estándar de un proyecto Maven:

```
.
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           └── example
│   │               └── trabajandoconfuturos
│   │                   ├── Ejercicio1.java
│   │                   ├── Ejercicio2.java
│   │                   └── Ejercicio3.java
├── pom.xml
└── README.md
```

## Clases

El proyecto consta de tres clases principales:

- `Ejercicio1.java`: Esta clase representa un cliente HTTP simple que obtiene e imprime el contenido de una URL dada.
- `Ejercicio2.java`: Esta clase representa una utilidad para comprimir archivos y directorios.
- `Ejercicio3.java`: Esta clase descarga varias páginas web y las guarda en archivos individuales en un directorio específico. Luego, comprime todos los archivos en ese directorio en un solo archivo .ZIP.

## Cómo ejecutar el proyecto

Para ejecutar el proyecto, siga estos pasos:

1. Clone el repositorio en su máquina local.
2. Navegue hasta el directorio del proyecto.
3. Ejecute el comando `mvn clean install` para compilar el proyecto y generar el archivo JAR.
4. Ejecute el archivo JAR con el comando `java -jar target/nombre-del-archivo.jar`.
