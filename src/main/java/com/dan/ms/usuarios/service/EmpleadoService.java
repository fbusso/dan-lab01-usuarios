package com.dan.ms.usuarios.service;

import com.dan.ms.usuarios.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    Empleado crearEmpleado(Empleado empleado);

    Empleado actualizarEmpleado(Integer id, Empleado empleado);

    List<Empleado> obtenerTodos();

    Optional<Empleado> encontrarPorId(Integer id);

    void eliminarPorId(Integer id);
}
