package com.ottoluis.MaosAmigas.services;

import com.ottoluis.MaosAmigas.dto.ConsultaResponseDTO;
import com.ottoluis.MaosAmigas.dto.createDTO.ConsultaCreateDTO;
import com.ottoluis.MaosAmigas.enums.StatusConsulta;
import com.ottoluis.MaosAmigas.models.Consulta;
import com.ottoluis.MaosAmigas.models.SuportePsicologico;
import com.ottoluis.MaosAmigas.models.Usuario;
import com.ottoluis.MaosAmigas.repository.ConsultaRepository;
import com.ottoluis.MaosAmigas.repository.SuportePsicologicoRepository;
import com.ottoluis.MaosAmigas.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final SuportePsicologicoRepository psicologoRepository;

    public ConsultaService(
            ConsultaRepository consultaRepository,
            UsuarioRepository usuarioRepository,
            SuportePsicologicoRepository psicologoRepository
    ) {
        this.consultaRepository = consultaRepository;
        this.usuarioRepository = usuarioRepository;
        this.psicologoRepository = psicologoRepository;
    }

    public List<ConsultaResponseDTO> listar(String email, boolean administrador) {
        List<Consulta> consultas = administrador
                ? consultaRepository.findAll()
                : consultaRepository.findByUsuario_EmailOrderByDataAscHoraAsc(email);

        return consultas.stream()
                .map(this::paraResposta)
                .toList();
    }

    public ConsultaResponseDTO buscarPorId(
            Long id,
            String email,
            boolean administrador
    ) {
        Consulta consulta;

        if (administrador) {
            consulta = consultaRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Consulta não encontrada."
                    ));
        } else {
            consulta = consultaRepository.findByIdAndUsuario_Email(id, email)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Consulta não encontrada."
                    ));
        }

        return paraResposta(consulta);
    }

    public ConsultaResponseDTO salvar(ConsultaCreateDTO dados, String email) {
        if (dados.getData() == null
                || dados.getHora() == null
                || dados.getPsicologoId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Informe o psicólogo, a data e o horário."
            );
        }

        if (dados.getData().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "A data da consulta não pode estar no passado."
            );
        }

        if (dados.getData().isEqual(LocalDate.now())
                && dados.getHora().isBefore(LocalTime.now())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "O horário da consulta não pode estar no passado."
            );
        }

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Não foi possível identificar o usuário autenticado."
            );
        }

        SuportePsicologico psicologo = psicologoRepository
                .findById(dados.getPsicologoId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Psicólogo não encontrado."
                ));

        boolean horarioOcupado =
                consultaRepository.existsByPsicologoIdAndDataAndHora(
                        psicologo.getId(),
                        dados.getData(),
                        dados.getHora()
                );

        if (horarioOcupado) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Este horário já está ocupado. Escolha outro."
            );
        }

        Consulta consulta = new Consulta();
        consulta.setUsuario(usuario);
        consulta.setPsicologo(psicologo);
        consulta.setData(dados.getData());
        consulta.setHora(dados.getHora());
        consulta.setObservacao(dados.getObservacao());
        consulta.setStatus(StatusConsulta.AGENDADA);

        return paraResposta(consultaRepository.save(consulta));
    }

    private ConsultaResponseDTO paraResposta(Consulta consulta) {
        return new ConsultaResponseDTO(
                consulta.getId(),
                consulta.getPsicologo().getId(),
                consulta.getPsicologo().getNomePsicologa(),
                consulta.getData(),
                consulta.getHora(),
                consulta.getStatus(),
                consulta.getObservacao(),
                consulta.getLinkAtendimento()
        );
    }
}
