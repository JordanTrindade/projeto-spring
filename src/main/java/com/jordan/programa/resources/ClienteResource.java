package com.jordan.programa.resources;

import com.jordan.programa.dominios.Cliente;
import com.jordan.programa.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id_cliente}")
    public ResponseEntity<?> getCliente(@PathVariable Integer id_cliente){
        
        Cliente obj = clienteService.buscarCliente(id_cliente);
        return ResponseEntity.ok().body(obj);
    }
}
