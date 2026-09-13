package com.ottoluis.MaosAmigas.controller;


import com.ottoluis.MaosAmigas.models.Consulta;
import com.ottoluis.MaosAmigas.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping
    public List <Consulta> listar(){
        return consultaRepository.findAll();
    }

    @PostMapping
    public Consulta salvar(@RequestBody Consulta consulta){
        return consultaRepository.save(consulta);
    }
}
