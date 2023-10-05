package org.example;

public class LanzadorProcesos {
    public void ejecutar(String ruta){

        ProcessBuilder pb;
        try{
            pb = new ProcessBuilder(ruta);
            pb.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
