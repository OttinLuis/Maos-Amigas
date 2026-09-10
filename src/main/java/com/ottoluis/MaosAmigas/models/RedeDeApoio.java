package com.ottoluis.MaosAmigas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ottoluis.MaosAmigas.models.embeddable.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "rede_de_apoio_tb")
public class RedeDeApoio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Column(name = "contato_da_ong", nullable = false)
    private String contatoDaOng;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Column(name = "nome_da_ong", nullable = false)
    private String nomeDaOng;

    @Embedded
    private Endereco endereco;


    public RedeDeApoio() {
    }

    public RedeDeApoio(Long id, String contatoDaOng, String nomeDaOng, Endereco endereco) {
        this.id = id;
        this.contatoDaOng = contatoDaOng;
        this.nomeDaOng = nomeDaOng;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContatoDaOng() {
        return contatoDaOng;
    }

    public void setContatoDaOng(String contatoDaOng) {
        this.contatoDaOng = contatoDaOng;
    }

    public String getNomeDaOng() {
        return nomeDaOng;
    }

    public void setNomeDaOng(String nomeDaOng) {
        this.nomeDaOng = nomeDaOng;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}