package org.example.ejercicio3;

import java.util.concurrent.atomic.AtomicInteger;

public class Contador {

    AtomicInteger contador;

    public void incrementarContador(){
        contador.incrementAndGet();
    }

    public int getContador(){
        return contador.get();
    }

}
