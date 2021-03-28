package com.dan.ms.usuarios.service;

import com.dan.ms.usuarios.model.Obra;
import com.dan.ms.usuarios.model.TipoObra;

import java.util.List;
import java.util.Optional;

public interface ObraService {

    Optional<Obra> encontrarPorId(Integer id);

    Obra crearObra(Obra obra);

    Obra actualizarObra(Integer id, Obra obra);

    List<Obra> encontrarPorIdOTipoObra(Integer id, TipoObra tipoObra);

    void eliminarPorId(Integer id);
}
