package org.example.ejercicio2;

public class Main {
    public static void main(String[] args) {

        Thread liebre = new Thread(() -> {
            carrera( "Liebre", 5);
        });
        Thread tortuga = new Thread(() -> {
            carrera("Tortuga", 1);
        });
        Thread caballo = new Thread(() -> {
            carrera("Caballo", 3);
        });
        Thread perro = new Thread(() -> {
            carrera("Perro", 2);
        });

        liebre.start();
        tortuga.start();
        caballo.start();
        perro.start();

        try {
            liebre.join();
            tortuga.join();
            caballo.join();
            perro.join();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }

    public static void carrera(String nombreAnimal, int probabilidadDeResbalar){
        for (int contador = 0; contador < 10; contador++){
            if (Math.random() < probabilidadDeResbalar){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(" - " + nombreAnimal + " ha lleagado a la meta.");
    }
}
