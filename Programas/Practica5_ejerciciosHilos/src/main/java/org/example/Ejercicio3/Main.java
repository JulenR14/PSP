package org.example.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numClientes = 200;
        int numUnidadesPS5 = 50;

        Tienda tienda = new Tienda(numUnidadesPS5);

        for (int i = 0; i < numClientes; i++) {
            Thread cliente = new Thread(new Cliente(tienda, i + 1));
            cliente.start();
        }
    }
}
