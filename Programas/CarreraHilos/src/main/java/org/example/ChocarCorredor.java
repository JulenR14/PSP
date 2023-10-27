package org.example;

public class ChocarCorredor extends Thread{

    private Corredor corredor;
    private int valorFinal;

    public ChocarCorredor(Corredor corredor, int valorFinal){
        this.corredor = corredor;
        this.valorFinal = valorFinal;
    }

    public void run(){
            try{
                corredor.retroceder();
                System.out.println(this.corredor.toString());
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
    }
}
