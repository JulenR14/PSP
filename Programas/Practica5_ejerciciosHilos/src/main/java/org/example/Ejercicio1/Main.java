package org.example.Ejercicio1;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Contenedor contenedor = new Contenedor();
        ArrayList<Productor> listaProductores= new ArrayList<>(){{
            add(new Productor(contenedor, "Charles", 10));
            add(new Productor(contenedor, "Alejandro", 20));
            add(new Productor(contenedor, "Julen", 50));
        }};
        ArrayList<Consumidor> listaConsumidores= new ArrayList<>(){{
            add(new Consumidor(contenedor, "Consumidor Marta"));
            add(new Consumidor(contenedor, "Consumidor Juan"));
        }};

        listaProductores.forEach(Productor::start);
        listaConsumidores.forEach(Consumidor::start);

        listaConsumidores.forEach(consumidor -> {
            try {
                consumidor.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        listaProductores.forEach(productor -> {
            try {
                productor.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}