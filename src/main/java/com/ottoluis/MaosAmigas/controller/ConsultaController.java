package com.ottoluis.MaosAmigas.controller;


import com.ottoluis.MaosAmigas.models.Consulta;
import com.ottoluis.MaosAmigas.models.SuportePsicologico;
import com.ottoluis.MaosAmigas.repository.ConsultaRepository;
import com.ottoluis.MaosAmigas.services.ConsultaService;
import com.ottoluis.MaosAmigas.services.PsicologosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaService consultaService;


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Long id){
        Consulta consulta = consultaService.buscarPorId(id);
        return ResponseEntity.ok(consulta);
    }


    @GetMapping
    public List <Consulta> listar(){
        return consultaRepository.findAll();
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public Consulta salvar(@RequestBody Consulta consulta){
        return consultaRepository.save(consulta);
    }
}
