package org.example;


import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Ejercicio1 {
    public static void main(String[] args) throws IOException {

        //claves para almacenar la listas de urls
        String clave_URLTOSHORT = "JULEN:URLS_TO_SHORT";
        String clave_SHORTEDURL = "JULEN:SHORTED_URLS";



        //pedimos el comando al usuario
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe el comando que quieras :\n" +
                "- shorten URL : URL es la url a acortar\n" +
                "- url SHORTEDURL : SHORTEDURL es la url acortada\n" +
                "- exit : Salir del programa");
        System.out.print("Escribe el comando que quieras :");
        String comando = bf.readLine();

        Thread acortador = new Thread(new Ejercicio2());

        //conectamos con el servidor de redis
        try(Jedis jedis = new Jedis("34.228.162.124", 6379)) {
            //iniciamos el hilo
            acortador.start();
            //borramos las claves para que no haya problemas
            jedis.del(clave_URLTOSHORT);
            while (!comando.equals("exit")) {
                //separamos el comando en palabras
                String[] comandoSplit = comando.split(" ");
                //comprobamos cual es el inicio del comando
                if (comandoSplit[0].equals("shorten")) {
                    String url = comandoSplit[1];
                    //añadimos la url a la lista
                    jedis.lpush(clave_URLTOSHORT, url);
                    System.out.println("En proceso de acortar la url");
                    //acortamos la url
                /*String[] separados = url.split("/");
                String shortedUrl = "";
                for(int i = 0; i < (separados.length-1); i++){
                    shortedUrl += separados[i] + "/";
                }
                //añadimos la url acortada al hash, la clave es la url acortada y el valor es la url
                //de esta forma cuando quiera buscar la url sera mas facil
                jedis.hset(clave_SHORTEDURL, shortedUrl, url);
                System.out.println("La url acortada es : " + shortedUrl);*/
                } else if (comandoSplit[0].equals("url")) {
                    String shortedUrl = comandoSplit[1];
                    //buscamos la url acortada en el hash
                    String url = jedis.hget(clave_SHORTEDURL, shortedUrl);
                    //comprobamos que la url existe
                    if (url == null) {
                        System.out.println("La url no existe");
                    } else {
                        //si existe la mostramos
                        System.out.println("La url es : " + url);
                    }
                } else {
                    System.out.println("Comando no valido");
                }
                System.out.print("Escribe el comando que quieras :");
                comando = bf.readLine();
            }
            acortador.join();
        }catch (Exception e){
            System.out.println("Error al conectar con la base de datos");
        }

    }
}