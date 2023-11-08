package org.example;

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
            posicionParque = (int) Math.random()*parques.length;
        }while (parques[posicionParque]);

        this.parques[posicionParque] = true;
        System.out.println("El jardinero " + Thread.currentThread().getName() + " esta trabajando en el parque " + posicionParque);
        return posicionParque;
    }
}
