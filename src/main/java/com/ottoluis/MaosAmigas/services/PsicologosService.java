package com.ottoluis.MaosAmigas.services;

import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.models.SuportePsicologico;
import com.ottoluis.MaosAmigas.repository.SuportePsicologicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsicologosService {

    @Autowired
    private SuportePsicologicoRepository suportePsicologicoRepository;

    public SuportePsicologico buscarPorId(Long id){
        return suportePsicologicoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Psicologo", id));

        }
}
