package com.dam.proyectospring.controladores;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.servicios.PilotoServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class APIController {
    private final PilotoServicio pilotoServicio;
    @Autowired
    public APIController(PilotoServicio pilotoServicio) {
        this.pilotoServicio = pilotoServicio;
    }

    // GET de todos los pilotos, devuelve un JSON con todos los pilotos
    @GetMapping(value = "/api/pilotos")
    public ResponseEntity<List<Piloto>> getProduct()
    {
        List<Piloto> pilotos = pilotoServicio.findAllPilotos();
        return new ResponseEntity<>(pilotos, HttpStatus.OK);
    }

    // GET de un piloto, devuelve un JSON del piloto
    @GetMapping("/piloto/{id}")
    public ResponseEntity<Piloto> getProduct(@PathVariable long id) {
        Optional<Piloto> piloto = pilotoServicio.findById(id);
        return new ResponseEntity<>(piloto.get(), HttpStatus.OK);
    }

    // POST de un piloto, crea un piloto
    @PostMapping("/pilotos")
    public ResponseEntity<Piloto> addProduct(@RequestBody Piloto piloto) {
        if (piloto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.pilotoServicio.savePiloto(piloto);
        // TODO Crear un nuevo pilot en la BB.DD. La información del nuevo piloto se encuentra en el objeto piloto
        // Para que llegue esta información en RESTED tenéis que poner en el body un JSON con la información del piloto a crear
        return new ResponseEntity<>(piloto, HttpStatus.OK);
    }

    // PUT de un piloto, actualiza un piloto
    @PutMapping("/pilotos/{id}")
    public ResponseEntity<Piloto> modifyProduct(@PathVariable long id, @RequestBody Piloto piloto) {
        this.pilotoServicio.savePiloto(piloto);
        // TODO Actualizar un nuevo pilot en la BB.DD. La información del nuevo piloto se encuentra en el objeto piloto
        // Para que llegue esta información en RESTED tenéis que poner en el body un JSON con la información del piloto a crear

        return new ResponseEntity<>(piloto, HttpStatus.OK);
    }

    @DeleteMapping("/pilotos/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable long id) {
        // TODO Borrar un producto
        this.pilotoServicio.deletePiloto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
