package org.example;

public class CorrerHilo extends Thread{
    private Corredor corredor;
    private int valorFinal;

    public CorrerHilo(Corredor corredor, int valorFinal){
        this.corredor = corredor;
        this.valorFinal = valorFinal;
    }

    public void run(){
        while(this.corredor.avanzar(valorFinal)){
            try{
                System.out.print(this.corredor.toString());
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
