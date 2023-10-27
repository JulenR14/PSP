package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Corredor> listaCorredores = new ArrayList<>();

        listaCorredores = InterfazUsuario.agregarCorredores();
        Carrera carrera = new Carrera(listaCorredores);

        carrera.empezarCarrera();

    }
}