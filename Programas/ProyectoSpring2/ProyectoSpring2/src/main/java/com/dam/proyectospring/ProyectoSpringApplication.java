package com.dam.proyectospring;

import com.dam.proyectospring.modelos.Piloto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.Scanner;

// La clase principal de la aplicación Spring Boot
@SpringBootApplication
public class ProyectoSpringApplication {
    // El método principal de la aplicación
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot
        SpringApplication.run(ProyectoSpringApplication.class, args);

        // Crea un nuevo escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        // Crea un nuevo cliente web para hacer solicitudes a la API
        WebClient webClient = WebClient.create("http://localhost:8080");

        // Bucle principal para el menú de la aplicación
        while (!opcion.equals("0")) {
            // Imprime las opciones del menú
            System.out.println("1. Mostrar todos los pilotos");
            System.out.println("2. Mostrar un piloto dado un id");
            System.out.println("3. Crear un piloto con nuevos datos");
            System.out.println("4. Actualizar un piloto dado un id concreto");
            System.out.println("5. Borrar un piloto dado un id");
            System.out.println("0. Salir");
            System.out.println("Elige una opción: ");
            // Lee la opción del usuario
            opcion = scanner.nextLine();

            // Maneja la opción del usuario
            switch (opcion) {
                case "1":
                    // Obtiene todos los pilotos de la API y los imprime
                    Flux<Piloto> pilotos = webClient.get()
                            .uri("/pilotos")
                            .retrieve()
                            .bodyToFlux(Piloto.class);
                    pilotos.doOnNext(System.out::println).blockLast();
                    break;
                case "2":
                    // Pide al usuario un ID de piloto, obtiene ese piloto de la API y lo imprime
                    System.out.println("Escribe el id del piloto que quieres buscar: ");
                    Flux<Piloto> piloto = webClient.get()
                            .uri("/piloto/" + scanner.nextLine())
                            .retrieve().
                            bodyToFlux(Piloto.class);
                    piloto.doOnNext(System.out::println).blockLast();
                    break;
                case "3":
                    // Crea un nuevo piloto y lo publica en la API
                    Piloto pilotoAgregar = crearPiloto();
                    webClient.post()
                            .uri("/pilotos")
                            .bodyValue(pilotoAgregar)
                            .retrieve()
                            .bodyToMono(Piloto.class)
                            .doOnNext(System.out::println)
                            .block();
                    break;
                case "4":
                    // Pide al usuario un ID de piloto, crea un nuevo piloto y actualiza el piloto con ese ID en la API
                    Piloto pilotoModificar = crearPiloto();
                    webClient.put()
                            .uri("/pilotos/" + pilotoModificar.getId())
                            .bodyValue(pilotoModificar)
                            .retrieve()
                            .bodyToMono(Piloto.class)
                            .doOnNext(System.out::println)
                            .block();
                    break;
                case "5":
                    // Pide al usuario un ID de piloto y borra ese piloto de la API
                    System.out.println("Escribe el id del piloto que quieres borrar:");
                    webClient.delete()
                            .uri("/pilotos/" + scanner.nextLine())
                            .retrieve()
                            .bodyToMono(Void.class)
                            .block();
                    break;
                case "0":
                    // Sale de la aplicación
                    System.out.println("Salir");
                    System.exit(0);
                    break;
                default:
                    // Maneja una opción no válida
                    System.out.println("Opción no válida");
            }
        }
    }

    // Método para crear un nuevo objeto Piloto
    public static Piloto crearPiloto() {
        // Crea un nuevo objeto Piloto
        Piloto piloto = new Piloto();
        // Crea un nuevo escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Pide al usuario los detalles del piloto y los establece en el objeto Piloto
        System.out.println("Introduce el nombre del piloto: ");
        piloto.setNombre(scanner.nextLine());
        System.out.println("Introduce la abreviatura: ");
        piloto.setAbreviatura(scanner.nextLine());
        System.out.println("Introduce el numero del piloto: ");
        piloto.setNumero(Integer.parseInt(scanner.nextLine()));
        System.out.println("Introduce el equipo del piloto: ");
        piloto.setEquipo(scanner.nextLine());
        System.out.println("Introduce el país del piloto: ");
        piloto.setPais(scanner.nextLine());
        System.out.println("Introduce la fecha de nacimiento del piloto: ");
        piloto.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));
        System.out.println("introduce el id del piloto: ");
        piloto.setId(scanner.nextLine());
        // Devuelve el objeto Piloto
        return piloto;
    }
}