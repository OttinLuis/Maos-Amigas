package com.ottoluis.MaosAmigas.controller;

import com.ottoluis.MaosAmigas.models.Consulta;
import com.ottoluis.MaosAmigas.services.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USUARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Long id) {

        Consulta consulta = consultaService.buscarPorId(id);

        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listar() {

        List<Consulta> consultas = consultaService.listar();

        return ResponseEntity.ok(consultas);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Consulta> salvar(@RequestBody Consulta consulta) {

        Consulta novaConsulta = consultaService.salvar(consulta);

        return ResponseEntity.ok(novaConsulta);
    }
}