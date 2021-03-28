package com.dan.ms.usuarios.repository;

import com.dan.ms.usuarios.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findDistinctByCuit(String cuit);

    List<Cliente> findAllByRazonSocial(String razonSocial);
}
