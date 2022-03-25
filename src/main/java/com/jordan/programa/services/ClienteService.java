package com.jordan.programa.services;

import java.util.Optional;

import com.jordan.programa.dominios.Cliente;
import com.jordan.programa.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente buscarCliente(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);

        return obj.orElseThrow(()-> new com.jordan.programa.services.exception.ObjectNotFoundException("Objeto não encontrado"));
    }
}
