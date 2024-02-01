package org.example.trabajandoconfuturos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Esta clase representa un cliente HTTP simple que obtiene e imprime el contenido de una URL dada.
 */
public class Ejercicio1 {
    /**
     * El método principal de la clase.
     * Solicita al usuario que introduzca una URL, luego envía una solicitud GET a esa URL e imprime el cuerpo de la respuesta.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Crear un BufferedReader para leer la entrada del usuario
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Escribe la url a la que quieras acceder : ");
        String url = "";
        try {
            // Leer la URL del usuario
            url = br.readLine();

            // Crear un HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Construir una HttpRequest a la URL especificada
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Enviar la solicitud HTTP y obtener la respuesta
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Imprimir el cuerpo de la respuesta
            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println("Error al leer la url");
        }
    }
}