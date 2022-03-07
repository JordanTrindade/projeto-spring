package com.jordan.programa.services;

import java.util.Optional;

import com.jordan.programa.dominios.Categoria;
import com.jordan.programa.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaServices {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
