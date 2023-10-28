package org.example;

public class VerCarrera extends Thread{
    private Carrera carrera = new Carrera();

    public VerCarrera(Carrera carrera){
        this.carrera = carrera;
    }

    public void run(){
        while(!this.carrera.getTerminarCarrera()){
            try{
                carrera.showRace();
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
