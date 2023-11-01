package org.example.Ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filosofo implements Runnable{

    String nombre;
    Mesa mesa;
    int posicionPalilloIzquierdo;
    int posicionPalilloDerecho;

    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                if(mesa.cogerPalillos(posicionPalilloIzquierdo, posicionPalilloDerecho)){
                    System.out.println("Filosofo " + this.nombre + " comiendo");
                    Thread.sleep((long) (Math.random() * 1000));
                    mesa.soltarPalillos(posicionPalilloIzquierdo, posicionPalilloDerecho);
                    System.out.println("Filosofo " + this.nombre + " pensando");
                    Thread.sleep((long) (Math.random() * 1000));
                }else{
                    System.out.println("Filosofo " + this.nombre + " esperando");
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
