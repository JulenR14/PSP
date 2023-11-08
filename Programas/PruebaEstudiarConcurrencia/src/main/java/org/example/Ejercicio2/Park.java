package org.example.Ejercicio2;

import lombok.Data;

@Data
public class Park {

    private int id;
    private boolean limpiando;
    private int endGardenId;

    public Park(int id){
        this.id = id;
        this.limpiando = false;
        this.endGardenId = -1;
    }

    public boolean comprobarCorrectoLimpio(){
        return Math.random() * 100 < 40;
    }

}
