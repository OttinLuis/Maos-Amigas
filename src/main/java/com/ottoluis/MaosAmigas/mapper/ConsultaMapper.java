package com.ottoluis.MaosAmigas.mapper;

import com.ottoluis.MaosAmigas.dto.createDTO.ConsultaCreateDTO;
import com.ottoluis.MaosAmigas.models.Consulta;

public class ConsultaMapper {

    public static Consulta toEntity(ConsultaCreateDTO dto) {

        Consulta consulta = new Consulta();

        consulta.setData(dto.getData());
        consulta.setHora(dto.getHora());
        consulta.setObservacao(dto.getObservacao());

        return consulta;
    }
}