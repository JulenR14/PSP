package org.example;

import javafx.collections.ListChangeListener;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Dowloader  implements ListChangeListener<String> {

    //cuando cambie la lista de urls se ejecutara este metodo
    //change es el objeto que contiene la información del cambio
    @Override
    public void onChanged(Change<? extends String> change) {
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(change.getList().get(change.getList().size()-1)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Se ha iniciado la descarga del archivo " + change.getList().get(change.getList().size()-1)) ;
    }
}
