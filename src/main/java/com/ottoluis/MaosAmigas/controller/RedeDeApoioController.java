package com.ottoluis.MaosAmigas.controller;


import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.models.RedeDeApoio;

import com.ottoluis.MaosAmigas.repository.RedeDeApoioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apoio")
public class RedeDeApoioController {

    private final RedeDeApoioRepository redeDeApoioRepository;

    public RedeDeApoioController(RedeDeApoioRepository redeDeApoioRepository) {
        this.redeDeApoioRepository = redeDeApoioRepository;
    }

    @GetMapping
    public List<RedeDeApoio> listar() {
        return redeDeApoioRepository.findAll();
    }

    @PostMapping
    public RedeDeApoio salvar(@RequestBody RedeDeApoio redeDeApoio){
        return redeDeApoioRepository.save(redeDeApoio);
    }

    @PutMapping("/{id}")
    public RedeDeApoio atualizar(
            @PathVariable Long id,
            @RequestBody RedeDeApoio dados) {

        RedeDeApoio apoio = redeDeApoioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Rede de apoio", id));

        apoio.setNomeDaOng(dados.getNomeDaOng());
        apoio.setContatoDaOng(dados.getContatoDaOng());
        apoio.setEndereco(dados.getEndereco());

        return redeDeApoioRepository.save(apoio);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!redeDeApoioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Rede de apoio", id);
        }
        redeDeApoioRepository.deleteById(id);
    }
}