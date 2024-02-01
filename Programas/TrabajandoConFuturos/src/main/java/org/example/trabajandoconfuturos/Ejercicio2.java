package org.example.trabajandoconfuturos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Esta clase representa una utilidad para comprimir archivos y directorios.
 */
public class Ejercicio2 {

    /**
     * El método principal de la clase.
     * Solicita al usuario que introduzca las rutas de los archivos o directorios a comprimir y la ruta donde se almacenará el archivo comprimido.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe la primera ruta : ");
        String ruta1 = sc.nextLine();
        System.out.print("Escribe la segunda ruta : ");
        System.out.print("Escribe la ruta donde se almacenara el archivo comprimido: ");
        String rutaComprimir = sc.nextLine();

        File fileAcomprimir = new File(ruta1);

        if (fileAcomprimir.isFile()){
            System.out.println("Es un fichero");
            comprimirFichero(fileAcomprimir, rutaComprimir);
        }else if (fileAcomprimir.isDirectory()) {
            System.out.println("Es un directorio");
            if (!rutaComprimir.endsWith("/")){
                rutaComprimir += "/";
            }
            FileOutputStream fos = new FileOutputStream(rutaComprimir+ "comprimido.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            comprimirCarpeta(fileAcomprimir, fileAcomprimir.getName(), zipOut);
            zipOut.close();
            fos.close();
        }

        sc.close();

    }

    /**
     * Este método comprime un archivo en un archivo .zip.
     *
     * @param fichero1 El archivo a comprimir.
     * @param rutaAlmacenarZip La ruta donde se almacenará el archivo comprimido.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void comprimirFichero(File fichero1, String rutaAlmacenarZip) throws IOException {

        if (!rutaAlmacenarZip.endsWith("/")){
            rutaAlmacenarZip += "/";
        }
        FileOutputStream fos = new FileOutputStream(rutaAlmacenarZip+ "compr.zip");
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

    /**
     * Este método comprime un directorio en un archivo .zip.
     *
     * @param fichero1 El directorio a comprimir.
     * @param nombreFichero El nombre del archivo comprimido.
     * @param zipOut El flujo de salida del archivo .zip.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public static void comprimirCarpeta(File fichero1, String nombreFichero, ZipOutputStream zipOut) throws IOException {

        if (fichero1.isHidden()){
            return;
        }
        if(nombreFichero.endsWith("/")){
            zipOut.putNextEntry(new ZipEntry(nombreFichero));
            zipOut.closeEntry();
        }else {
            zipOut.putNextEntry(new ZipEntry(nombreFichero + "/"));
            zipOut.closeEntry();
        }
        File[] ficheros = fichero1.listFiles();
        for (File fichero : ficheros){
            if (fichero.isDirectory()){
                comprimirCarpeta(fichero, nombreFichero + "/" + fichero.getName(), zipOut);
                continue;
            }
            FileInputStream fis = new FileInputStream(fichero);
            ZipEntry zipEntry = new ZipEntry(nombreFichero + "/" + fichero.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0){
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
    }
}