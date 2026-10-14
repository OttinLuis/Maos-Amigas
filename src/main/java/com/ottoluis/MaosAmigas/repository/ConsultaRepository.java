package com.ottoluis.MaosAmigas.repository;

import com.ottoluis.MaosAmigas.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPsicologoIdAndDataAndHora(
            Long psicologoId,
            LocalDate data,
            LocalTime hora
    );

    List<Consulta> findByUsuario_EmailOrderByDataAscHoraAsc(String email);

    Optional<Consulta> findByIdAndUsuario_Email(Long id, String email);
}
