package com.dan.ms.usuarios.service;

import com.dan.ms.usuarios.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> obtenerTodos();

    Usuario crearUsuario(Usuario usuario);
}
