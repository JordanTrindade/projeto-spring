package com.jordan.programa.services;

import java.util.Optional;

import com.jordan.programa.dominios.Categoria;
import com.jordan.programa.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(()-> new com.jordan.programa.services.exception.ObjectNotFoundException("Objeto não encotrado"));
    }
}
