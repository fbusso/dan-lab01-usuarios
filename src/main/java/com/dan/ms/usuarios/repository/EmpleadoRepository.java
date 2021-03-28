package com.dan.ms.usuarios.repository;

import com.dan.ms.usuarios.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
