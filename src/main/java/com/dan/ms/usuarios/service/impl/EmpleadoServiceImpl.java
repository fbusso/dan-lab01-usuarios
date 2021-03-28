package com.dan.ms.usuarios.service.impl;

import com.dan.ms.usuarios.model.Empleado;
import com.dan.ms.usuarios.model.Usuario;
import com.dan.ms.usuarios.repository.EmpleadoRepository;
import com.dan.ms.usuarios.service.EmpleadoService;
import com.dan.ms.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,
                               UsuarioService usuarioService) {
        this.empleadoRepository = empleadoRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        Usuario usuario = usuarioService.crearUsuario(empleado.getUsuario());
        empleado.setUsuario(usuario);
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado actualizarEmpleado(Integer id, Empleado empleado) {
        empleado.setId(id);
        return empleadoRepository.save(empleado);
    }


    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> encontrarPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
