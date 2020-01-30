package com.example.controller;

import com.example.model.Usuario;
import com.example.service.UsuarioService;
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
public class UsuarioController {
    
    @Autowired
    UsuarioService service;
    
    @GetMapping("/usuarios")
    public List<Usuario>listarUsuarios(){
        return service.listadoUsuarios();
    }
    
    @GetMapping({"/usuarios/{id}"})
    public Usuario listaUnUsuario(@PathVariable("id") int id){
        return service.unUsuario(id);
    }
    
    @GetMapping({"/usuarios/name/{name}"})
    public Usuario listaUnUsuario(@PathVariable("name") String name){
        return service.unUsuarioUN(name);
    }
    
    @PostMapping("/usuarios")
    public Usuario altaUsuario(@RequestBody Usuario u){
        return service.altaUsuario(u); 
    }
    
    @PutMapping(path={"/usuarios/{id}"})
    public Usuario modificarUsuario(@RequestBody Usuario u, @PathVariable("id") int id){
        u.setId(id);
        return service.modificarUsuario(u);
    }
    
    @DeleteMapping(path={"/usuarios/{id}"})
    public Usuario bajaUsuario(@PathVariable ("id") int id){
        return service.bajaUsuario(id);
    }  
}
