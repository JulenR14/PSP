package org.example;

import javafx.collections.ListChangeListener;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Dowloader  implements ListChangeListener<String> {

    Path directorioWebs = Paths.get("src/webs");

    //cuando cambie la lista de urls se ejecutara este metodo
    //change es el objeto que contiene la información del cambio
    @Override
    public void onChanged(Change<? extends String> change) {
        HttpClient client = HttpClient.newHttpClient();
        String url = change.getList().get(change.getList().size()-1);

        try {
            if(Files.notExists(directorioWebs)){
                Files.createDirectory(directorioWebs);
            }

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String nombreFichero = "Web_" + (change.getList().size()) + ".html";
            Path fichero = directorioWebs.resolve(nombreFichero);

            Files.writeString(fichero, response.body(), StandardCharsets.UTF_8);

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("ALGO HA SALIDO MAL, VUELVE A INTENTARLO");
        }

        System.out.println("Se ha iniciado la descarga del archivo " + change.getList().get(change.getList().size()-1)) ;
    }
}
