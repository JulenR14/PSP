package org.example.trabajandoconfuturos;

import java.io.*;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ejercicio2 {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe la primera ruta : ");
        String ruta1 = sc.nextLine();
        System.out.print("Escribe la segunda ruta : ");
        String ruta2 = sc.nextLine();
        System.out.print("Escribe la ruta donde se almacenara el archivo comprimido: ");
        String rutaComprimir = sc.nextLine();

        File fileAcomprimir = new File(ruta1);

        if (fileAcomprimir.isFile()){
            System.out.println("Es un fichero");
            comprimirFichero(fileAcomprimir, rutaComprimir);
        }


        sc.close();

    }

    public static void comprimirFichero(File fichero1, String rutaAlmacenarZip) throws IOException {

        if (!rutaAlmacenarZip.endsWith("/")){
            rutaAlmacenarZip += "/";
        }
        FileOutputStream fos = new FileOutputStream(rutaAlmacenarZip+ "comprimido.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        FileInputStream fis = new FileInputStream(fichero1);
        ZipEntry zipEntry = new ZipEntry(fichero1.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0){
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();

    }

    public static void comprimirCarpeta(File fichero1, String rutaAlmacenarZip) throws IOException {


    }
}
