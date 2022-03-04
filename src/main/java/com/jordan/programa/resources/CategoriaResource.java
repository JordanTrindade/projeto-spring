package com.jordan.programa.resources;

import com.jordan.programa.dominios.Pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @RequestMapping(method = RequestMethod.GET)
    public Pessoa Listar(){
        Pessoa p1 = new Pessoa("jordan");
        return p1;
    }
}
