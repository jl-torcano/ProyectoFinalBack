package com.example.service;

import com.example.model.Cliente;
import java.util.List;


public interface ClienteService {
    
    List<Cliente>listadoClientes();
    Cliente unCliente(String dni);
    Cliente altaCliente(Cliente c);
    Cliente modificarCliente(Cliente c);
    Cliente bajaCliente(String dni);
}
