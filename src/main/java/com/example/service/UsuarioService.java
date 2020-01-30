package com.example.service;

import com.example.model.Usuario;
import java.util.List;

public interface UsuarioService {
    
    List<Usuario>listadoUsuarios();
    Usuario unUsuario(int id);
    Usuario unUsuarioUN(String username);
    Usuario altaUsuario(Usuario u);
    Usuario modificarUsuario(Usuario u);
    Usuario bajaUsuario(int id);
}
