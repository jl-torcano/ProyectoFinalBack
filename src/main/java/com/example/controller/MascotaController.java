package com.example.controller;

import com.example.model.Mascota;
import com.example.service.MascotaService;
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
public class MascotaController {
    
    @Autowired
    MascotaService service;

    @GetMapping("/mascotas")
    public List<Mascota>listar(){
        return service.listadoMascotas();
    }
    
    @GetMapping({"/mascotas/{id}"})
    public Mascota listaUnaMascota(@PathVariable("id") int id){
        return service.unaMascota(id);
    }
    
    @GetMapping({"/mascotas/tipo/{tipo}"})
    public List<Mascota> listaTipoMascota(@PathVariable("tipo") String tipo){
        return service.tipoMascota(tipo);
    }
    
    @GetMapping({"/mascotas/historial/{estado}"})
    public List<Mascota> listaMascotaVendida(@PathVariable("estado") String estado){
        return service.listadoMascotasVendidas(Integer.parseInt(estado));
    }
        
    @PostMapping("/mascotas")
    public Mascota alta(@RequestBody Mascota m){
        return service.altaMascota(m); 
    }
    
    @PutMapping(path={"/mascotas/{id}"})
    public Mascota modificar(@RequestBody Mascota m, @PathVariable("id") int id){
        m.setId(id);
        return service.modificarMascota(m);
    }

    @DeleteMapping(path={"/mascotas/{id}"})
    public Mascota bajaMascota(@PathVariable ("id") int id){
        return service.bajaMascota(id);
    }
}