package com.dan.ms.usuarios.service.impl;

import com.dan.ms.usuarios.model.Obra;
import com.dan.ms.usuarios.model.TipoObra;
import com.dan.ms.usuarios.repository.ObraRepository;
import com.dan.ms.usuarios.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObraServiceImpl implements ObraService {

    private final ObraRepository obraRepository;

    @Autowired
    public ObraServiceImpl(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @Override
    public Obra crearObra(Obra obra) {
        return obraRepository.save(obra);
    }

    @Override
    public Obra actualizarObra(Integer id, Obra obra) {
        obra.setId(id);
        return obraRepository.save(obra);
    }

    @Override
    public Optional<Obra> encontrarPorId(Integer id) {
        return obraRepository.findById(id);
    }

    @Override
    public List<Obra> encontrarPorIdOTipoObra(Integer id, TipoObra tipoObra) {
        return obraRepository.findAllByIdEqualsOrTipoObra(id, tipoObra);
    }

    @Override
    public void eliminarPorId(Integer id) {
        obraRepository.deleteById(id);
    }
}
