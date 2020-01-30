package com.example.controller;

import com.example.model.Cliente;
import com.example.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
@RequestMapping
class ClienteController {
    
    @Autowired
    ClienteService service; 
    
    @GetMapping("/clientes")
    public List<Cliente>listarCliente(){
        return service.listadoClientes();
    }   
    
    @GetMapping({"/clientes/{dni}"})
    public Cliente listaUnCliente(@PathVariable("dni") String dni){
        return service.unCliente(dni);
    }
    
    @PostMapping("/clientes")
    public Cliente alta(@RequestBody Cliente c){
        return service.altaCliente(c); 
    }

    @PutMapping(path={"/clientes/{dni}"})
    public Cliente modificar(@RequestBody Cliente c, @PathVariable("dni") String dni){
        c.setDni(dni);
        return service.modificarCliente(c);
    }
    
    @DeleteMapping(path={"/clientes/{dni}"})
    public Cliente bajaMascota(@PathVariable ("dni") String dni){
        return service.bajaCliente(dni);
    }

}
