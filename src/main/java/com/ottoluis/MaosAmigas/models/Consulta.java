package com.ottoluis.MaosAmigas.models;

import com.ottoluis.MaosAmigas.enums.StatusConsulta;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "consulta_tb")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "psicologo_id", nullable = false)
    private SuportePsicologico psicologo;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status;

    @Column(columnDefinition = "TEXT")
    private String observacao;

    private String linkAtendimento;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        if (dataCriacao == null) {
            dataCriacao = LocalDateTime.now();
        }

        if (status == null) {
            status = StatusConsulta.AGENDADA;
        }
    }

    public Consulta() {
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public SuportePsicologico getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(SuportePsicologico psicologo) {
        this.psicologo = psicologo;
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

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLinkAtendimento() {
        return linkAtendimento;
    }

    public void setLinkAtendimento(String linkAtendimento) {
        this.linkAtendimento = linkAtendimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Consulta consulta = (Consulta) o;
        return Objects.equals(id, consulta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}