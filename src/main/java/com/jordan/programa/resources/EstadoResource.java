package com.jordan.programa.resources;

import com.jordan.programa.dominios.Estado;
import com.jordan.programa.services.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService EstadoService;

    @GetMapping(value="/{id_estado}")
    public ResponseEntity<?> getEstado(@PathVariable Integer id_estado){
        
        Estado obj =  EstadoService.buscarEstado(id_estado);
        return ResponseEntity.ok().body(obj);
    }
}  