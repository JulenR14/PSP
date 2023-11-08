package org.example.Ejercicio1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Town {

    Boolean[] parques;

    public Town(int cantidadParques){
        parques = new Boolean[cantidadParques];
        for(int i = 0; i < cantidadParques; i++){
            parques[i] = false;
        }
    }

    public synchronized int trabajar(){
        int posicionParque = 0;
        do{
            posicionParque = (int) (Math.random() * parques.length);
        }while (parques[posicionParque]);

        this.parques[posicionParque] = true;
        System.out.println("The garden " + Thread.currentThread().getName() + " is working on the park " + posicionParque);
        return posicionParque;
    }

    public synchronized boolean dejarParque(int posicion){
        parques[posicion] = false;
        System.out.println("Garden " + Thread.currentThread().getName() + " is done with the park " + posicion);
        return !parques[posicion];
    }
}
