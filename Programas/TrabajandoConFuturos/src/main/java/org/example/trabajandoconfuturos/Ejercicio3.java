package org.example.trabajandoconfuturos;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Esta clase descarga varias páginas web y las guarda en archivos individuales en un directorio específico.
 * Luego, comprime todos los archivos en ese directorio en un solo archivo .ZIP.
 */
public class Ejercicio3 {

    /**
     * El método principal de la clase.
     * Crea una lista de URLs, descarga cada página web y las guarda en archivos en un directorio específico.
     * Luego, comprime todos los archivos en ese directorio en un solo archivo .ZIP.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) throws IOException {
        List<String> urls = Arrays.asList(
                "https://www.elperiodicomediterraneo.com/",
                "https://www.marca.com/",
                "https://es.duolingo.com/",
                "https://www.mercadona.es/",
                "https://www.pccomponentes.com/",
                "https://github.com/",
                "https://web.telegram.org/",
                "https://www.netflix.com/browse"
        );

        Path directorioWebs = Paths.get("src/main/java/org/example/trabajandoconfuturos/webs");
        if (!Files.exists(directorioWebs)) {
            Files.createDirectory(directorioWebs);
        }

        HttpClient client = HttpClient.newHttpClient();
        for (String url : urls) {
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String fileName = url.split("/")[2] + ".html";
                Path directorio = directorioWebs.resolve(fileName);

                Files.writeString(directorio, response.body(), StandardCharsets.UTF_8);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        FileOutputStream fos = new FileOutputStream("src/main/java/org/example/trabajandoconfuturos/webs.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File file = new File("src/main/java/org/example/trabajandoconfuturos/webs");
        comprimirCarpeta(file, file.getName(), zipOut);

    }

    /**
     * Este método comprime un directorio en un archivo .zip.
     *
     * @param fichero1 El directorio a comprimir.
     * @param nombreFichero El nombre del archivo comprimido.
     * @param zipOut El flujo de salida del archivo .zip.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void comprimirCarpeta(File fichero1, String nombreFichero, ZipOutputStream zipOut) throws IOException {

        zipOut.putNextEntry(new ZipEntry(nombreFichero + "/"));
        zipOut.closeEntry();

        File[] ficheros = fichero1.listFiles();
        for (File fichero : ficheros){
            if (fichero.isDirectory()){
                comprimirCarpeta(fichero, nombreFichero + "/" + fichero.getName(), zipOut);
                continue;
            }
            FileInputStream fis = new FileInputStream(fichero);
            ZipEntry zipEntry = new ZipEntry(nombreFichero + "/" + fichero.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0){
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
    }

}