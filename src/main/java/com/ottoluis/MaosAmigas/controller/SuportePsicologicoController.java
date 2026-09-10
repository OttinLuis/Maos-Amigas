package com.ottoluis.MaosAmigas.controller;


import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.models.SuportePsicologico;
import com.ottoluis.MaosAmigas.repository.SuportePsicologicoRepository;
import com.ottoluis.MaosAmigas.services.PsicologosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/psicologos")
public class SuportePsicologicoController {


    @Autowired
    private SuportePsicologicoRepository suportePsicologicoRepository;

    @Autowired
    private PsicologosService psicologosService;

    @GetMapping
    public List<SuportePsicologico> listar() {
        return suportePsicologicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuportePsicologico> buscarPorId(@PathVariable Long id){
        SuportePsicologico suportePsicologico = psicologosService.buscarPorId(id);
        return ResponseEntity.ok(suportePsicologico);
    }

    @PostMapping
    public SuportePsicologico salvar(@RequestBody SuportePsicologico suportePsicologico) {
        return suportePsicologicoRepository.save(suportePsicologico);
    }

    @PutMapping("/{id}")
    public SuportePsicologico atualizar(
            @PathVariable Long id,
            @RequestBody SuportePsicologico dados) {

        SuportePsicologico psicologo = suportePsicologicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Psicologo", id));

        psicologo.setNomePsicologa(dados.getNomePsicologa());
        psicologo.setCrp(dados.getCrp());
        psicologo.setEspecialidade(dados.getEspecialidade());
        psicologo.setSobreMim(dados.getSobreMim());
        psicologo.setContatoPsicologa(dados.getContatoPsicologa());
        psicologo.setEmailPsicologa(dados.getEmailPsicologa());
        psicologo.setRedeSocial(dados.getRedeSocial());
        psicologo.setImgUrl(dados.getImgUrl());

        return suportePsicologicoRepository.save(psicologo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!suportePsicologicoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Psicologo", id);
        }
        suportePsicologicoRepository.deleteById(id);
    }
}

