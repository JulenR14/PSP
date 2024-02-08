package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;

import java.util.List;
import java.util.Optional;

public interface PilotoServicio {
    List<Piloto> findAllPilotos();

    Optional<Piloto> findById(Long id);

    Piloto savePiloto(Piloto piloto);

    void deletePiloto(Long id);
}
