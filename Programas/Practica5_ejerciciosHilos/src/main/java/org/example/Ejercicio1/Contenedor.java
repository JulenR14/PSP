package org.example.Ejercicio1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

@Data
@AllArgsConstructor
public class Contenedor {
    private ArrayList<AtomicInteger> datos;
    private final int CAPACIDAD;

    public Contenedor(){
        this.datos = new ArrayList<>();
        this.CAPACIDAD = 4;
    }

    public synchronized boolean isEmpty(){
        return datos.isEmpty();
    }

    public synchronized boolean isFull(){
        return datos.size() == CAPACIDAD;
    }

    public synchronized int get(){
        int datoCorrespondiente;
        while (this.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        datoCorrespondiente = datos.get(datos.size()-1).get();
        datos.remove(datos.size() - 1);
        notifyAll();
        return datoCorrespondiente;
    }

    public synchronized void put(int value){
        while (this.isFull()){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        datos.add(new AtomicInteger(value));
        notifyAll();
    }
}
