
package org.example;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Object> locations = new ArrayList<>();
        Object objetoJson = new Object();

        URL url  =  new URL("https://rickandmortyapi.com/api/location");

        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();

        connection.setRequestMethod("GET");

        if(connection.getResponseCode() == 200){
            System.out.println("Conexion realizada con exito");
        }

        Path ruta = Path.of(url.getPath());
        objetoJson = MetodosJson.leerArrayObjetoJSON(ruta);

        System.out.println(objetoJson);
    }
}