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
        Jedis jedis = new Jedis("34.228.162.124", 6379);

        String clave_URLTOSHORT = "JULEN:URLS_TO_SHORT";
        String clave_SHORTEDURL = "JULEN:SHORTED_URLS";

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe el comando que quieras :\n" +
                "- shorten URL : URL es la url a acortar\n" +
                "- url SHORTEDURL : SHORTEDURL es la url acortada\n" +
                "- exit : Salir del programa");
        System.out.print("Escribe el comando que quieras :");
        String comando = bf.readLine();


        jedis.del(clave_URLTOSHORT);
        while (!comando.equals("exit")) {
            String[] comandoSplit = comando.split(" ");
            if (comandoSplit[0].equals("shorten")) {
                String url = comandoSplit[1];
                jedis.lpush(clave_URLTOSHORT, url);
                String[] separados = url.split("/");
                String shortedUrl = "";
                for(int i = 0; i < (separados.length-1); i++){
                    shortedUrl += separados[i] + "/";
                }
                jedis.hset(clave_SHORTEDURL, shortedUrl, url);
                System.out.println("La url acortada es : " + shortedUrl);
            } else if (comandoSplit[0].equals("url")) {
                String shortedUrl = comandoSplit[1];
                String url = jedis.hget(clave_SHORTEDURL, shortedUrl);
                if (url == null) {
                    System.out.println("La url no existe");
                } else {
                    System.out.println("La url es : " + url);
                }
            } else {
                System.out.println("Comando no valido");
            }
            System.out.print("Escribe el comando que quieras :");
            comando = bf.readLine();
        }

    }
}