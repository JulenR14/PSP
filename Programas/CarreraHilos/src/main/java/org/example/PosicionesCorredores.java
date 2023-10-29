package org.example;

import java.util.ArrayList;

public class PosicionesCorredores {
    private ArrayList<String> posiciones;

    public PosicionesCorredores(){
        this.posiciones = new ArrayList<>();
    }

    synchronized void agregar(String corredor){
        this.posiciones.add(corredor);
    }

    public String getCorredor(int indice){
        return this.posiciones.get(indice);
    }

    public int tamanoCorredores(){
        return this.posiciones.size();
    }
}
