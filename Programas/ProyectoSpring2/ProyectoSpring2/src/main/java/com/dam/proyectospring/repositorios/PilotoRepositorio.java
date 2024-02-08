package com.dam.proyectospring.repositorios;

import com.dam.proyectospring.modelos.Piloto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PilotoRepositorio extends MongoRepository<Piloto, String> {
    Piloto findById(Long id);

    void deleteById(Long id);
    List<Piloto> findByNombreContaining(String nombre);
    List<Piloto> findByEquipoOrderByNumero(String equipo);

}
