package com.ottoluis.MaosAmigas.services;


import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.models.RedeDeApoio;
import com.ottoluis.MaosAmigas.models.SuportePsicologico;
import com.ottoluis.MaosAmigas.repository.RedeDeApoioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedeDeApoioService {

    @Autowired
    private RedeDeApoioRepository redeDeApoioRepository;

    public RedeDeApoio buscarPorId(Long id){
        return redeDeApoioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Rede de apoio", id));

    }
}
