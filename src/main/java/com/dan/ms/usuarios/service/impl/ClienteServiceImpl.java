package com.dan.ms.usuarios.service.impl;

import com.dan.ms.usuarios.model.Cliente;
import com.dan.ms.usuarios.model.Usuario;
import com.dan.ms.usuarios.repository.ClienteRepository;
import com.dan.ms.usuarios.service.ClienteService;
import com.dan.ms.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              UsuarioService usuarioService) {
        this.clienteRepository = clienteRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        Usuario usuario = usuarioService.crearUsuario(cliente.getUsuario());
        cliente.setUsuario(usuario);
        cliente.setHabilitadoOnline(false);
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> encontrarPorCuit(String cuit) {
        return clienteRepository.findDistinctByCuit(cuit);
    }

    @Override
    public List<Cliente> encontrarPorRazonSocial(String razonSocial) {
        return clienteRepository.findAllByRazonSocial(razonSocial);
    }


}
