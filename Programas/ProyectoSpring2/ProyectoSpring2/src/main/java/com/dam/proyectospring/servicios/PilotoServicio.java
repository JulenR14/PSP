package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;

import java.util.List;

public interface PilotoServicio {
    List<Piloto> findAllPilotos();

    Piloto findById(Long id);

    void savePiloto(Piloto piloto);

    void deletePiloto(Long id);
}
