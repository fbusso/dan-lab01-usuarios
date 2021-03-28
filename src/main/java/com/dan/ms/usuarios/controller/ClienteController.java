package com.dan.ms.usuarios.controller;

import com.dan.ms.usuarios.model.Cliente;
import com.dan.ms.usuarios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.createCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> obtenerTodos() {
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @GetMapping("/cuit/{cuit}")
    public ResponseEntity<Cliente> obtenerPorCuit(@PathVariable String cuit) {
        return ResponseEntity.of(clienteService.encontrarPorCuit(cuit));
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> obtenerPorRazonSocial(@RequestParam(required = false) String razonSocial) {
        return ResponseEntity.ok(clienteService.encontrarPorRazonSocial(razonSocial));
    }
}
