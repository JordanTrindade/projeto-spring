package com.jordan.programa.services;

import java.util.Optional;

import com.jordan.programa.dominios.Estado;
import com.jordan.programa.repositories.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService  {

    @Autowired
    private EstadoRepository est;

    public Estado buscarEstado(Integer id){

        Optional <Estado> obj = est.findById(id);
        return obj.orElseThrow(()-> new com.jordan.programa.services.exception.ObjectNotFoundException("Objeto não encontrado"));

    }
}
