package org.example;

public class CorrerHilo extends Thread{
    private Corredor corredor;
    private Carrera carrera = new Carrera();
    private int valorFinal;

    public CorrerHilo(Corredor corredor, int valorFinal){
        this.corredor = corredor;
        this.valorFinal = valorFinal;
    }

    public void run(){
        while(this.corredor.avanzar(valorFinal)){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
