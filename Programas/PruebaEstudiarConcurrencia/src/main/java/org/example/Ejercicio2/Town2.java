package org.example.Ejercicio2;

import lombok.Data;

@Data
public class Town2 {
    private Park[] parques;

    public Town2(int cantidadParques){
        parques = new Park[cantidadParques];
        for(int i = 0; i < cantidadParques; i++){
            parques[i] = new Park(i);
        }
    }

    public boolean trabajandoEnParque(int id){
        return parques[id].isLimpiando();
    }

    public synchronized int trabajar(){
        int posicionParque = 0;
        do{
            posicionParque = (int) (Math.random() * parques.length);
        }while (parques[posicionParque].isLimpiando());

        this.parques[posicionParque].setLimpiando(true);
        System.out.println("El jardinero " + Thread.currentThread().getName() + " esta trabajando en el parque " + posicionParque);
        return posicionParque;
    }

    public synchronized void dejarParque(int id){
        this.parques[id].setLimpiando(false);
        System.out.println("El jardinero " + Thread.currentThread().getName() + " termino de trabajar en el parque " + id);
    }

    public synchronized boolean comprobarEstadoParque(int id){
        return parques[id].comprobarCorrectoLimpio();
    }
}
