package org.example.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Citizen extends Thread{

    Town2 town;
    List<String> listaQuejas;

    public Citizen(Town2 town){
        this.town = town;
        this.listaQuejas = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.println("Ciudadano " + this.getName() + " en busca de quejas.");
        int parque;

        long startTime = System.currentTimeMillis();
        long endTime = 0;
        while((endTime-startTime) < 10000L){
            parque = (int) (Math.random() * town.getParques().length);
            if (!town.trabajandoEnParque(parque)){
                if (!town.comprobarEstadoParque(parque)){
                    System.out.println("El parque " + parque + " no esta limpio");
                    listaQuejas.add("El parque " + parque + " no esta limpio");
                }
            }
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                System.out.println("El ciudadano ha dejado de quejarse.");
                return;
            }
            endTime = System.currentTimeMillis();
        }
        System.out.println("El ciudadano "+ this.getName() +" ha puesto " + this.listaQuejas.size() + " quejas");
    }


}
