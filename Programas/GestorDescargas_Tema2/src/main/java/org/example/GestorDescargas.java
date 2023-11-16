package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas {
    public static void main(String[] argumentos) throws IOException {

        String url = "https://www.boe.es/legislacion/documentos/ConstitucionCASTELLANO.pdf";
        GestorDescargas.descargarArchivo(url, "resultado.txt");
        File archivo = new File("resultado.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null)
            System.out.println(linea);

    }

    public static void descargarArchivo(String url_descargar, String nombreArchivo) {
        System.out.println("Descargando " + url_descargar);
        try {
            URL laUrl = new URL(url_descargar);
            InputStream is = laUrl.openStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(reader);
            FileWriter escritorFichero = new FileWriter(nombreArchivo);
            String linea;
            while ((linea = bReader.readLine()) != null) {
                escritorFichero.write(linea);
            }
            escritorFichero.close();
            bReader.close();
            reader.close();
            is.close();
        } catch (MalformedURLException e) {
            System.out.println("URL mal escrita!");
        } catch (IOException e) {
            System.out.println(
                    "Fallo en la lectura del fichero");
        }
    }
}