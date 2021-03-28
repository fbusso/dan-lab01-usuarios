package com.dan.ms.usuarios.controller;

import com.dan.ms.usuarios.model.Obra;
import com.dan.ms.usuarios.model.TipoObra;
import com.dan.ms.usuarios.service.ObraService;
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

    @PostMapping
    public ResponseEntity<Obra> crearObra(@RequestBody Obra obra) {
        return new ResponseEntity<>(obraService.crearObra(obra), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Obra> actualizarObra(@PathVariable(value = "id") Integer id,
                                               @RequestBody Obra obra) {
        return ResponseEntity.ok(obraService.actualizarObra(id, obra));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Obra> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.of(obraService.encontrarPorId(id));
    }

    @GetMapping()
    public ResponseEntity<List<Obra>> encontrarPorIdOTipoObra(@RequestParam(required = false) Integer id,
                                                              @RequestParam(required = false) TipoObra tipoObra) {
        return ResponseEntity.ok(obraService.encontrarPorIdOTipoObra(id, tipoObra));
    }

    @DeleteMapping
    public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
        obraService.eliminarPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
