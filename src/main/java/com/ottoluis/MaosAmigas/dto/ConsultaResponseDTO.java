package com.ottoluis.MaosAmigas.dto;

import com.ottoluis.MaosAmigas.enums.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalTime;

public record ConsultaResponseDTO(
        Long id,
        Long psicologoId,
        String psicologo,
        LocalDate data,
        LocalTime hora,
        StatusConsulta status,
        String observacao,
        String linkAtendimento
) {
}
