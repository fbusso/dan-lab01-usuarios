package com.dan.ms.usuarios.controller;

import com.dan.ms.usuarios.model.Obra;
import com.dan.ms.usuarios.model.TipoObra;
import com.dan.ms.usuarios.service.ObraService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

    private final ObraService obraService;

    @Autowired
    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @Operation(summary = "Crear una obra nueva")
    @PostMapping
    public ResponseEntity<Obra> crearObra(@RequestBody Obra obra) {
        return new ResponseEntity<>(obraService.crearObra(obra), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una obra")
    @PutMapping("/{id}")
    public ResponseEntity<Obra> actualizarObra(@PathVariable(value = "id") Integer id,
                                               @RequestBody Obra obra) {
        return ResponseEntity.ok(obraService.actualizarObra(id, obra));
    }

    @Operation(summary = "Obtener una obra por su id")
    @GetMapping("/id/{id}")
    public ResponseEntity<Obra> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.of(obraService.encontrarPorId(id));
    }

    @Operation(summary = "Obtener una lista de obras filtradas por id o tipo de obra")
    @GetMapping("/id-or-type")
    public ResponseEntity<List<Obra>> encontrarPorIdOTipoObra(@RequestParam(required = false) Integer id,
                                                              @RequestParam(required = false) TipoObra tipoObra) {
        return ResponseEntity.ok(obraService.encontrarPorIdOTipoObra(id, tipoObra));
    }

    @Operation(summary = "Eliminar una obra por su id")
    @DeleteMapping("{id}")
    public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
        obraService.eliminarPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
