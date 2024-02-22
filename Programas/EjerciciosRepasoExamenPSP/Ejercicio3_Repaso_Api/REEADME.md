# Ejercicio3RepasoApi

Este proyecto es una aplicación Spring Boot que proporciona una API REST para trabajar con fechas. La aplicación está escrita en Java y utiliza Maven como sistema de gestión de proyectos.

## Características

La aplicación proporciona los siguientes endpoints:

- `GET /api/date`: Devuelve la fecha actual.
- `GET /api/date/{dias}`: Devuelve la fecha después del número especificado de días.

## Estructura del proyecto

El proyecto sigue la estructura estándar de un proyecto Maven y está organizado en los siguientes paquetes:

- `org.julen.ejercicio3_repaso_api`: Contiene la clase principal de la aplicación, `Ejercicio3RepasoApiApplication`, que inicia la aplicación Spring Boot.
- `org.julen.ejercicio3_repaso_api.controller`: Contiene la clase `FechaController`, que maneja las solicitudes HTTP a los endpoints de la API.
- `org.julen.ejercicio3_repaso_api.models`: Contiene la clase `Fecha`, que es el modelo de datos utilizado en la aplicación.
- `org.julen.ejercicio3_repaso_api.services`: Contiene la interfaz `FechaService` y su implementación `FechaServiceImpl`. Estas clases proporcionan la lógica de negocio para trabajar con fechas.

## Cómo ejecutar el proyecto

Para ejecutar el proyecto, necesitarás tener instalado Java y Maven. A continuación, puedes clonar el repositorio y ejecutar el proyecto con Maven:

```bash
git clone https://github.com/JulenR14/Ejercicio3RepasoApi.git
cd Ejercicio3RepasoApi
mvn spring-boot:run
```

Una vez que la aplicación esté en ejecución, puedes acceder a los endpoints de la API en `http://localhost:8080/api/date` y `http://localhost:8080/api/date/{dias}`.


Julen Redondo Pérez