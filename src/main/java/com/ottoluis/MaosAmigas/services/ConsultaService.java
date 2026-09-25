package com.ottoluis.MaosAmigas.services;

import com.ottoluis.MaosAmigas.dto.createDTO.ConsultaCreateDTO;
import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.mapper.ConsultaMapper;
import com.ottoluis.MaosAmigas.models.Consulta;
import com.ottoluis.MaosAmigas.models.SuportePsicologico;
import com.ottoluis.MaosAmigas.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException("Consulta", id));
    }

    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }

    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}