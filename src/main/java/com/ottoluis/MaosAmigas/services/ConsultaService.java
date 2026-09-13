package com.ottoluis.MaosAmigas.services;

import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.models.Consulta;
import com.ottoluis.MaosAmigas.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta buscarPorId(Long id){
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("consulta", id));

    }
}
