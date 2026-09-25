package com.ottoluis.MaosAmigas.dto.createDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaCreateDTO {

    @Schema(
            description = "ID do psicólogo que realizará a consulta",
            example = "1"
    )
    @NotNull
    private Long psicologoId;

    @Schema(
            description = "Data da consulta",
            example = "2026-09-25"
    )
    @NotNull
    private LocalDate data;

    @NotNull
    private LocalTime hora;


    private String observacao;

    public ConsultaCreateDTO(){

    }

    public ConsultaCreateDTO(Long psicologoId, LocalDate data, LocalTime hora, String observacao) {
        this.psicologoId = psicologoId;
        this.data = data;
        this.hora = hora;
        this.observacao = observacao;
    }

    public Long getPsicologoId() {
        return psicologoId;
    }

    public void setPsicologoId(Long psicologoId) {
        this.psicologoId = psicologoId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}