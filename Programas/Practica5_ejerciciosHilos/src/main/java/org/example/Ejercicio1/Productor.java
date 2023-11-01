package org.example.Ejercicio1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productor extends Thread{

    Contenedor contenedor;
    String nombre;
    int identificador;

    public void run(){
        for (int i = 0; i <= 5; i++){
            contenedor.put(i+identificador);
            System.out.println(this.nombre + " produce : " + (i+identificador));
            try{
                sleep((int)(Math.random()*2000));
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
