package org.example.Ejercicio2;

import org.example.Ejercicio1.Town;

public class Gardener extends Thread{

    Town2 town;
    int contadorParques = 0;

    public Gardener(int id, Town2 town){
        this.setName("Hilo-"+id);
        this.town = town;
    }

    @Override
    public void run() {
        System.out.println("El jardinero " + this.getName() + " empieza.");
        int parque;

        long startTime = System.currentTimeMillis();
        long endTime = 0;
        while((endTime-startTime) < 10000L){
            parque = town.trabajar();
            try {
                town.dejarParque(parque);
                Thread.sleep(2000);
                contadorParques++;
                endTime = System.currentTimeMillis();
            } catch (InterruptedException e) {
                System.out.println("El jardinero ha dejado de trabajar.");
                return;
            }
        }
        System.out.println("El jardinero " + this.getName() + " ha terminado su trabajo");
    }
}
