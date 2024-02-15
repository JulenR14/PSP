# Proyecto Spring Boot

Este es un proyecto de Spring Boot que proporciona una API REST para gestionar pilotos de carreras. El proyecto utiliza MongoDB como base de datos y Spring WebFlux para manejar las solicitudes HTTP de forma reactiva.

## Características

El proyecto proporciona las siguientes operaciones a través de su API:

- Obtener todos los pilotos (`GET /pilotos`)
- Obtener un piloto específico por su ID (`GET /piloto/{id}`)
- Crear un nuevo piloto (`POST /pilotos`)
- Actualizar un piloto existente (`PUT /pilotos/{id}`)
- Eliminar un piloto existente (`DELETE /pilotos/{id}`)

Además, el proyecto incluye una interfaz de línea de comandos (CLI) que permite al usuario interactuar con la API de una manera más amigable.

## Requisitos

Para ejecutar este proyecto, necesitarás:

- Java 11 o superior
- Maven
- MongoDB

## Cómo ejecutar el proyecto

1. Clona este repositorio en tu máquina local.
2. Navega hasta el directorio del proyecto.
3. Ejecuta `mvn spring-boot:run` para iniciar la aplicación.
4. La aplicación estará disponible en `http://localhost:8080`.

## Cómo usar la CLI

Una vez que la aplicación esté en ejecución, puedes interactuar con la API a través de la CLI. Aquí están los comandos disponibles:

- `1`: Muestra todos los pilotos.
- `2`: Muestra un piloto específico por su ID.
- `3`: Crea un nuevo piloto.
- `4`: Actualiza un piloto existente.
- `5`: Elimina un piloto existente.
- `0`: Salir de la aplicación.
