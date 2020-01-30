package com.example.service;

import com.example.dao.MascotaRepository;
import com.example.model.Mascota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaServiceImp implements MascotaService{

    @Autowired
    private MascotaRepository repositorio;
    
    @Override
    public List<Mascota> listadoMascotas() {
        return repositorio.findAll();
    }

    @Override
    public Mascota unaMascota(int id) {
        return repositorio.findById(id);
    }

    @Override
    public List<Mascota> tipoMascota(String tipo) {
        return repositorio.findByTipo(tipo);
    }

    @Override
    public Mascota altaMascota(Mascota m) {
        return repositorio.save(m);
    }

    @Override
    public Mascota modificarMascota(Mascota m) {
        return repositorio.save(m);
    }

    @Override
    public Mascota bajaMascota(int id) {
        Mascota m = repositorio.findById(id);
        if(m!=null){
            repositorio.delete(m);
        }
        return m;
    }

    @Override
    public List<Mascota> listadoMascotasVendidas(int estado) {
        return repositorio.findByVendida(estado);
    }
    
}
