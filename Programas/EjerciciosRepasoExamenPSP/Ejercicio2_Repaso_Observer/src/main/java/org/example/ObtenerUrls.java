package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;
import java.util.Scanner;

public class ObtenerUrls {

    //dowloader es el objeto que implementa la interfaz ListChangeListener
    //escuchara los cambios en la lista de urls
    Dowloader dowloader = new Dowloader();
    Scanner sc = new Scanner(System.in);
    ObservableList<String> urls = FXCollections.observableArrayList();

    /*
     * Metodo que pide al usuario que introduzca las urls de los archivos que quiere descargar
     */
    public void pedirUrls() {
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
