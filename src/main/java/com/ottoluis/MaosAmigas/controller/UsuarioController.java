package com.ottoluis.MaosAmigas.controller;


import com.ottoluis.MaosAmigas.dto.createDTO.CreateUsuarioDTO;
import com.ottoluis.MaosAmigas.dto.UsuarioDTO;
import com.ottoluis.MaosAmigas.exception.RecursoNaoEncontradoException;
import com.ottoluis.MaosAmigas.mapper.UsuarioMapper;
import com.ottoluis.MaosAmigas.models.Usuario;
import com.ottoluis.MaosAmigas.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }

    @PostMapping
    public UsuarioDTO salvar(@Valid @RequestBody CreateUsuarioDTO dto) {

        Usuario usuario = UsuarioMapper.toEntity(dto);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return UsuarioMapper.toDto(usuarioSalvo);
    }

    @PutMapping("/{id}")
    public UsuarioDTO atualizar(
            @PathVariable Long id,
            @RequestBody CreateUsuarioDTO dto) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario", id));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setCpf(dto.getCpf());
        usuario.setEndereco(dto.getEndereco());
        usuario.setContatoConfianca(dto.getContatoConfianca());
        usuario.setContatoPessoal(dto.getContatoPessoal());
        usuario.setDataNascimento(dto.getDataNascimento());

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return UsuarioMapper.toDto(usuarioAtualizado);

    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Usuario", id);
        }
        usuarioRepository.deleteById(id);
    }
}