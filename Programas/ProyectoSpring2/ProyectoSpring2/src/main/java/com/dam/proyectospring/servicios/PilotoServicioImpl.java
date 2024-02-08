package com.dam.proyectospring.servicios;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.repositorios.PilotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Piloto findById(Long id) {
        return pilotoRepositorio.findById(id);
    }

    @Override
    public void savePiloto(Piloto piloto) {
        pilotoRepositorio.save(piloto);
    }

    @Override
    public void deletePiloto(Long id) {
        pilotoRepositorio.deleteById(id);
    }

}
