package org.example;

import java.util.ArrayList;

public class Carrera {
    private ArrayList<Corredor> listaCorredores;
    private ArrayList<CorrerHilo> hilosCorredores = new ArrayList<>();
    private int valorFinal = 100;

    public Carrera(ArrayList<Corredor> listaCorredores){
        this.listaCorredores = listaCorredores;
        for (Corredor corredor : listaCorredores){
            hilosCorredores.add(new CorrerHilo(corredor, valorFinal));
        }
    }

    public void empezarCarrera(){
        for(CorrerHilo hilo : hilosCorredores){
            hilo.start();
        }
    }
}
