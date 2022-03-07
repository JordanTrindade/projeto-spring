package com.jordan.programa.repositories;

import com.jordan.programa.dominios.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>{
    
}
