package org.julen.ejercicio3_repaso_api.controller;

import org.julen.ejercicio3_repaso_api.models.Fecha;
import org.julen.ejercicio3_repaso_api.services.FechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta es una clase controladora Rest para manejar solicitudes relacionadas con la fecha.
 * Utiliza la anotación @RestController de Spring para indicar que es una clase controladora.
 */
@RestController
public class FechaController {

    // FechaService Autowired para usar sus métodos.
    @Autowired
    private FechaService fechaServie;

    /**
     * Este método maneja las solicitudes GET a "/api/date".
     * Devuelve la fecha actual.
     * @return ResponseEntity que contiene el objeto Fecha y el estado HTTP.
     */
    @GetMapping("api/date")
    public ResponseEntity<Fecha> fechaActual(){
        Fecha fecha = fechaServie.fechaActual();
        return new ResponseEntity<>(fecha, HttpStatus.OK);
    }

    /**
     * Este método maneja las solicitudes GET a "/api/date/{dias}".
     * Devuelve la fecha después del número especificado de días.
     * @param dias El número de días a añadir a la fecha actual.
     * @return ResponseEntity que contiene el objeto Fecha y el estado HTTP.
     */
    @GetMapping("api/date/{dias}")
    public ResponseEntity<Fecha> fechaMasDias(@PathVariable int  dias){
        Fecha fecha = fechaServie.fechaMasDias(dias);
        return new ResponseEntity<>(fecha, HttpStatus.OK);
    }

}