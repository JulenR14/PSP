package org.example.Ejercicio1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumidor extends Thread{

    Contenedor contenedor;
    String nombre;

    public void run(){
        int value = 0;
        for (int i = 0; i <= 5; i++){
            value = contenedor.get();
            System.out.println(this.nombre + " consume : " + value);
            try{
                sleep((int)(Math.random()*2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
