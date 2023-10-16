package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Clase Command.
 * Esta clase se encargara de ejecutar los comandos que se le pasen por parametro.
 * Tambien se encargara de almacenar la salida de los comandos en un fichero.
 */
public class Command {
    //Atributos
    String[] comandos;
    String ficheroSalida;

    //Constructores
    public Command(String[] comandos, String ficheroSalida){
        this.comandos = comandos;
        this.ficheroSalida = ficheroSalida;
    }
    public Command(String comandosConSalida){
        //separo los comandos y el fichero donde se tiene que ejecutar segun la separacion
        String[] comandos = comandosConSalida.split(">");
        //comprobamos que tengamos dos posiciones en la lista
        if(comandos.length > 1){
            //guradamos los comandos en la lista separando por espacios el string donde se encuentran los comandos
            this.comandos = comandos[0].split(" ");
            //almacenamos el fichero en la variable del mismo
            this.ficheroSalida = comandos[1];
        }else{
            //si no se separa el string quiere decir que el fichero no esta definido
            this.comandos = comandos;
            this.ficheroSalida = "";
        }
    }

    /**
     * Metodo ejecutar.
     * Este metodo se encargara de ejecutar el comando que se le pase por parametro
     * mediante un ProcessBuilder.
     * Tambien se encargara de almacenar la salida del comando en un fichero.
     *
     * @return String con la salida del comando.
     */
    public String ejecutar(){
        //atributos
        String salida = "";
        String linea = "";
        try {
            //instanciamos un ProcessBuilder con la ruta donde se ejecutara el proceso, y le pasamos los comandos
            //ProcessBuilder para ejecutar en linux
            ProcessBuilder prepararProceso = new ProcessBuilder("/bin/bash", "-c", String.join(" ", comandos));

            //ProcessBuilder para ejecutar en windows
            //ProcessBuilder prepararProceso = new ProcessBuilder("cmd.exe", "/c", String.join(" ", comandos));

            //inicializamos el proceso con el metodo .start()
            Process proceso = prepararProceso.start();

            //instanciamos un BufferedReader para que lea el resultado del proceso
            BufferedReader bf = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            //mientras que la linea no sea null el bucle seguira, de esta porfa recorreremos todas las lineas del proceso
            while(linea != null){
                //en salida se ira acumulando cada linea del proceso
                salida += linea + "\n";
                //leemos la siguiente linea del proceso
                linea = bf.readLine();
            }

            //en el caso de que tengamos fichero de salida, escribiremos en el fichero la salida
            if(!ficheroSalida.isEmpty()){
                //instanciamos un objeto PrintWriter y le pasamos el fichero donde se escribira la salida
                PrintWriter imprimir = new PrintWriter(ficheroSalida);
                //metodo que escribe en el fichero la informacion acumulada en la variable salida
                imprimir.println(salida);
                //cerramos el PrintWriter
                imprimir.close();
                //dejamos la saldida vacia para que no nos lo imprima mas adelante
                salida = "";
            }
        //capturamos posible excepcion
        }catch (Exception e){
            e.getMessage();
        }
        //devolvemos salida
        return salida;
    }

    /**
     * Metodo toString.
     * Este metodo se encargara de devolver un string con la informacion del comando.
     *
     * @return String con la informacion del comando.
     */
    @Override
    public String toString() {

        String devolver = "Comando " + comandos[0] + " Cantidad de parametros : " + (comandos.length-1) + " Parametros : \n";
        for (int contador = 1 ; contador < comandos.length; contador++){
            devolver += "- " + comandos[contador] + "\n";
        }

        return devolver;
    }
}
