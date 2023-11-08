package org.example.Ejercicio1;

public class Garden extends Thread{

    Town town;
    int contadorParques = 0;

    public Garden(int id, Town town){
        this.setName("Hilo-"+id);
        this.town = town;
    }

    @Override
    public void run() {
        System.out.println("Garden " + this.getName() + " is running");
        int parque;

        long startTime = System.currentTimeMillis();
        long endTime = 0;
        while((endTime-startTime) < 10000L){
            parque = town.trabajar();
            try {
                Thread.sleep(2000);
                if(town.dejarParque(parque)){
                    contadorParques++;
                }
                endTime = System.currentTimeMillis();
            } catch (InterruptedException e) {
                System.out.println("El thread is end");
                return;
            }
        }
        System.out.println("Garden " + this.getName() + " has finished the work.");
    }
}
