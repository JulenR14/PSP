package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Shell {
    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Command comando = null;
        Command ultimoComando = null;
        try{
            System.out.print("Escribe el comando que quieras (Si quieres almacenar la salida en un fichero\n" +
                    "escribe el comando y seguido > con el fichero donde almacenar la salida)\n" +
                    "Comando : ");
            String comandoUsuario = bf.readLine();

            while(!comandoUsuario.equals("exit")){
                if (comandoUsuario.equals("last-command")){
                    if (ultimoComando.equals(null)){
                        System.err.println("No hay ultimo comando...");
                    }else{
                        System.out.println(ultimoComando.ejecutar());
                    }
                }else{
                    comando = new Command(comandoUsuario);
                    System.out.println(comando.ejecutar());
                    ultimoComando = comando;
                }
                System.out.print("Comando : ");
                comandoUsuario = bf.readLine();
            }
        }catch (IOException e){
            e.getMessage();
        }
    }
}