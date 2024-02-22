# Proyecto de Descarga de Archivos

Este proyecto es una aplicación de consola simple escrita en Java que permite a los usuarios descargar archivos de Internet a través de URLs proporcionadas por el usuario.

## Características

- Solicita al usuario que introduzca las URLs de los archivos que desea descargar.
- Inicia la descarga de archivos cuando se proporciona una URL.
- Permite al usuario terminar la ejecución del programa escribiendo 'exit'.

## Estructura del Código

El proyecto consta de tres clases principales:

1. `Main.java`: Esta es la clase principal que inicia la aplicación. Crea una instancia de la clase `ObtenerUrls` y llama al método `pedirUrls()`.

2. `ObtenerUrls.java`: Esta clase se encarga de solicitar al usuario las URLs de los archivos que desea descargar. Mantiene una lista observable de URLs y agrega un `Dowloader` como oyente a esta lista. Cuando se agrega una nueva URL a la lista, se notifica al `Dowloader`.

3. `Dowloader.java`: Esta clase implementa la interfaz `ListChangeListener<String>`. Cuando se agrega una nueva URL a la lista en `ObtenerUrls`, el método `onChanged()` de esta clase se activa, iniciando la descarga del archivo.

## Cómo Ejecutar

Para ejecutar este proyecto, necesitarás tener instalado Java y Maven. Una vez que los tengas instalados, puedes clonar este repositorio y ejecutar el proyecto con los siguientes comandos:

```bash
git clone <url del repositorio>
cd <directorio del proyecto>
mvn clean install
java -cp target/<nombre del archivo jar> org.example.Main
```

## Dependencias

Este proyecto utiliza las siguientes dependencias:

- JavaFX: Utilizado para la lista observable y el oyente de la lista.

Julen Redondo Pérez