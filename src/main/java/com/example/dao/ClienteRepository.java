package com.example.dao;

import com.example.model.Cliente;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface ClienteRepository extends Repository<Cliente, Integer>{
    
    List<Cliente> findAll();
    Cliente findByDni(String dni);
    Cliente save(Cliente c);
    Cliente delete(Cliente c);
}
