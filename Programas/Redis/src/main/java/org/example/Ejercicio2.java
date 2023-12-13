package org.example;

import redis.clients.jedis.Jedis;

public class Ejercicio2 implements Runnable {
    @Override
    public void run() {
        boolean salir = false;
        String clave_URLTOSHORT = "JULEN:URLS_TO_SHORT";
        String clave_SHORTEDURL = "JULEN:SHORTED_URLS";

        try(Jedis jedis = new Jedis("34.228.162.124", 6379)){
            while(true){
                //eliminamos la ultima url de la lista y la acortamos metiendola en el hash
                String url = jedis.lpop(clave_URLTOSHORT);
                if(url != null){
                    String[] separados = url.split("/");
                    String shortedUrl = "";
                    for(int i = 0; i < (separados.length-1); i++){
                        shortedUrl += separados[i] + "/";
                    }
                    jedis.hset(clave_SHORTEDURL, shortedUrl, url);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
