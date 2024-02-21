package org.example;

import javafx.collections.ListChangeListener;

public class Dowloader  implements ListChangeListener<String> {

    //cuando cambie la lista de urls se ejecutara este metodo
    //change es el objeto que contiene la información del cambio
    @Override
    public void onChanged(Change<? extends String> change) {
        System.out.println("Se ha iniciado la descarga del archivo " + change.getList().get(change.getList().size()-1)) ;
    }
}
