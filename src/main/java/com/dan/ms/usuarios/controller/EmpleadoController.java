package com.dan.ms.usuarios.controller;

import com.dan.ms.usuarios.model.Empleado;
import com.dan.ms.usuarios.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @Operation(summary = "Crear un empleado nuevo")
    @PostMapping
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.crearEmpleado(empleado), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un empleado")
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable(value = "id") Integer id,
                                                       @RequestBody Empleado empleado) {
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(id, empleado));
    }

    @Operation(summary = "Obtener un empleado por su id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.of(empleadoService.encontrarPorId(id));
    }

    @Operation(summary = "Obtener la lista completa de empleados")
    @GetMapping("/all")
    ResponseEntity<List<Empleado>> obtenerTodos() {
        return ResponseEntity.ok(empleadoService.obtenerTodos());
    }

    @Operation(summary = "Eliminar un empleado por su id")
    @DeleteMapping("{id}")
    ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
        empleadoService.eliminarPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
