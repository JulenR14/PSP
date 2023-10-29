package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CorrerHilo extends Thread{
    private Corredor corredor;
    private int valorFinal;
    private PosicionesCorredores posicionesCorredores;


    public void run(){
        while(this.corredor.avanzar(valorFinal)){
            try{
                sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.posicionesCorredores.agregar(this.corredor.getSimbolo());
    }
}
