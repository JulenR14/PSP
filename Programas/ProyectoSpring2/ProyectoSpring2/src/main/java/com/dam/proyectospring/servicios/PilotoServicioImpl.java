package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.repositorios.PilotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoServicioImpl implements PilotoServicio {
    private final PilotoRepositorio pilotoRepositorio;

    @Autowired
    public PilotoServicioImpl(PilotoRepositorio pilotoRepositorio) {
        this.pilotoRepositorio = pilotoRepositorio;
    }

    @Override
    public List<Piloto> findAllPilotos() {
        return pilotoRepositorio.findAll();
    }

    @Override
    public Optional<Piloto> findById(String id) {
        return pilotoRepositorio.findById(String.valueOf(id));
    }

    @Override
    public Piloto savePiloto(Piloto piloto) {
        return pilotoRepositorio.save(piloto);
    }

    @Override
    public void deletePiloto(String id) {
        pilotoRepositorio.deleteById(id);
    }

}
