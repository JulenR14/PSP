package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Shell {
    /**
     * Metodo main de la clase Shell.
     * Este metodo se encargara de ejecutar el shell
     * y de leer los comandos que se escriban por consola.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {


        //instanciamos un BufferedReader para leer los comandos escritos por consola
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Command comando = null;
        Command ultimoComando = null;

        try{

            System.out.print("Escribe el comando que quieras (Si quieres almacenar la salida en un fichero\n" +
                    "escribe el comando y seguido > con el fichero donde almacenar la salida)\n" +
                    "Comando : ");
            //leemos el comando
            String comandoUsuario = bf.readLine();

            //comprobamos si el comando es exit para comprobar si quiere salir del shell
            while(!comandoUsuario.equals("exit")){
                //comprobamos si quiere ejecutar el ultimo comando ejecutado
                if (comandoUsuario.equals("last-command")){
                    //en el caso de que el ultimo comando sea null mostraremos un mensaje de error
                    if (ultimoComando.equals(null)){
                        System.err.println("No hay ultimo comando...");
                    }else{
                        //si no es nulo, llamamos al metodo que ejecutara el comando anterior
                        System.out.println(ultimoComando.ejecutar());
                        ultimoComando.toString();
                    }
                }else{
                    //si no quiere el ultimo comando
                    //instanciaremos en la variable comando el nuevo comando a ejecutar
                    comando = new Command(comandoUsuario);
                    //llamaremos al metodo que ejecutara dicho comando
                    System.out.println(comando.ejecutar());
                    //diermos que el ultimo comando es el comando que se acaba de ejecutar
                    ultimoComando = comando;
                    comando.toString();
                }
                //pedimos el siguiente comando a ejecutar
                System.out.print("Comando : ");
                comandoUsuario = bf.readLine();


            }
        }catch (IOException e){
            e.getMessage();
        }
    }
}