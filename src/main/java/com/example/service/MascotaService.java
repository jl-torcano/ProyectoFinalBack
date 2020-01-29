package com.example.service;

import com.example.model.Mascota;
import java.util.List;



public interface MascotaService {
    List<Mascota>listadoMascotas();
    Mascota unaMascota(int id);
    List<Mascota> tipoMascota(String tipo);
    Mascota altaMascota(Mascota m);
    Mascota modificarMascota(Mascota m);
    Mascota bajaMascota(int id);    
}