package org.example.Ejercicio3;

public class Tienda {
    private int unidadesPS5;

    public Tienda(int unidadesPS5) {
        this.unidadesPS5 = unidadesPS5;
    }

    public synchronized boolean comprarPS5() {
        if (unidadesPS5 > 0) {
            unidadesPS5--;
            return true;
        }
        return false;
    }
}
