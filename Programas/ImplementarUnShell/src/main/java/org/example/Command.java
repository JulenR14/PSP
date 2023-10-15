package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.SimpleTimeZone;

public class Command {
    //Atributos
    String[] comandos;
    String ficheroSalida = "";

    //Constructores
    public Command(String[] comandos, String ficheroSalida){
        this.comandos = comandos;
        this.ficheroSalida = ficheroSalida;
    }
    public Command(String comandosConSalida){
        String[] comandos = comandosConSalida.split(">");
        if(comandos.length > 1){
            this.comandos = comandos[0].split(" ");
            this.ficheroSalida = comandos[1];
        }else{
            this.comandos = comandos;
            this.ficheroSalida = "";
        }
    }

    public String ejecutar(){
        String salida = "";
        String linea = "";
        try {
            ProcessBuilder prepararProceso = new ProcessBuilder(this.comandos);
            //prepararProceso.directory(new File("C:\\Users\\julen\\Documents\\GitHub\\PSP\\Programas\\LanzadorProcesos\\src\\Shell"));
            Process proceso = prepararProceso.start();

            BufferedReader bf = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            while(linea != null){
                salida += linea + "\n";
                linea = bf.readLine();
            }

            if(!ficheroSalida.isEmpty()){
                PrintWriter imprimir = new PrintWriter(ficheroSalida);
                imprimir.println(salida);
                imprimir.close();
                salida = "";
            }

        }catch (Exception e){
            e.getMessage();
        }

        return salida;
    }

    @Override
    public String toString() {

        String devolver = "Comando " + comandos[0] + " Cantidad de parametros : " + (comandos.length-1) + " Parametros : \n";
        for (int contador = 1 ; contador < comandos.length; contador++){
            devolver += "- " + comandos[contador] + "\n";
        }

        return devolver;
    }
}
