package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChocarCorredor extends Thread{

    private Corredor corredor;
    private int valorFinal;

    @Override
    public void run(){
            while(this.corredor.retroceder(valorFinal)){
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
    }
}
