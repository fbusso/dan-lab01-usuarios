package com.dan.ms.usuarios.repository;

import com.dan.ms.usuarios.model.Obra;
import com.dan.ms.usuarios.model.TipoObra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObraRepository extends JpaRepository<Obra, Integer> {
    List<Obra> findAllByIdEqualsOrTipoObra(Integer id, TipoObra tipoObra);
}
