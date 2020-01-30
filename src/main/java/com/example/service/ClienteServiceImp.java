package com.example.service;

import com.example.dao.ClienteRepository;
import com.example.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImp implements ClienteService{
    
    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> listadoClientes() {
        return repositorio.findAll();
    }

    @Override
    public Cliente unCliente(String dni) {
        return repositorio.findByDni(dni);
    }

    @Override
    public Cliente altaCliente(Cliente c) {
        return repositorio.save(c);
    }

    @Override
    public Cliente modificarCliente(Cliente c) {
        return repositorio.save(c);
    }

    @Override
    public Cliente bajaCliente(String dni) {
        Cliente c = repositorio.findByDni(dni);
        if(c!=null){
            repositorio.delete(c);
        }
        return c;
    }
    
}
