package org.example.Ejercicio3;

import lombok.Getter;

import java.util.Random;

public class Cliente implements Runnable{
    private Tienda tienda;
    private int clienteID;

    public Cliente(Tienda tienda, int clienteID) {
        this.tienda = tienda;
        this.clienteID = clienteID;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            System.out.println("Cliente " + clienteID + " intenta entrar en la tienda (Intento " + i + ")");

            if (tienda.comprarPS5()) {
                System.out.println("Cliente " + clienteID + " ha comprado una PlayStation 5 y se va. -------------------------------------------");
                return;
            } else {
                System.out.println("Cliente " + clienteID + " no pudo comprar una PlayStation 5 en el intento " + i);
            }

            try {
                Thread.sleep(random.nextInt(2000)); // Espera aleatoria entre intentos.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Cliente " + clienteID + " se va sin comprar una PlayStation 5.");
    }

}
