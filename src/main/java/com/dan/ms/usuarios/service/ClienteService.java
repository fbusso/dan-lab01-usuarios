package com.dan.ms.usuarios.service;

import com.dan.ms.usuarios.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente createCliente(Cliente cliente);

    List<Cliente> obtenerTodos();

    Optional<Cliente> encontrarPorCuit(String cuit);

    List<Cliente> encontrarPorRazonSocial(String razonSocial);

}
