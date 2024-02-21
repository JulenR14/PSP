package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Scanner;

public class ObtenerUrls {

    //dowloader es el objeto que implementa la interfaz ListChangeListener
    //escuchara los cambios en la lista de urls
    Dowloader dowloader = new Dowloader();
    Scanner sc = new Scanner(System.in);
    ObservableList<String> urls = FXCollections.observableArrayList();

    Path directorioWebs = Paths.get("src/webs");
    /*
     * Metodo que pide al usuario que introduzca las urls de los archivos que quiere descargar
     */
    public void pedirUrls() {

        if(Files.notExists(directorioWebs)){
            try {
                Files.createDirectory(directorioWebs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //se añade el objeto dowloader a la lista de escuchadores de la lista de urls
        urls.addListener(dowloader);
        System.out.println("Si quieres terminar de ejecutar el programa escribe 'exit'");
        String url = "";
        do{
            System.out.println("Introduce la url del archivo que quieres descargar : ");
            url = sc.nextLine();

            if(!url.equalsIgnoreCase("exit")){
                urls.add(url);
            }
        }while(!url.equalsIgnoreCase("exit"));
    }
}
