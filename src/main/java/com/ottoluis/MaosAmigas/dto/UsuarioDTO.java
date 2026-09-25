package com.ottoluis.MaosAmigas.dto;

import com.ottoluis.MaosAmigas.models.embeddable.Endereco;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embedded;

public class UsuarioDTO {
    private Long id;

    @Schema(
            description = "Nome completo do usuário",
            example = "Joao da Silva Santos"
    )
    private String nome;


    @Schema(
            description = "Email do usário",
            example = "joao@gmail.com"
    )
    private String email;


    @Schema(
            description = "Data de nascimento do usuário",
            example = "10/10/2010"
    )
    private String dataNascimento;


    @Schema(
            description = "Contato do usuário",
            example = "(99)99999-9999"
    )
    private String contatoPessoal;


    @Schema(
            description = "Contato de confiança do usário",
            example = "(99)99999-9999"
    )
    private String contatoConfianca;

    @Embedded
    private Endereco endereco;

    public UsuarioDTO(){

    }

    public UsuarioDTO(Long id, String nome, String email, String dataNascimento, Endereco endereco, String contatoPessoal, String contatoConfianca) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco =  endereco;
        this.contatoPessoal = contatoPessoal;
        this.contatoConfianca =  contatoConfianca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getContatoPessoal() {
        return contatoPessoal;
    }

    public void setContatoPessoal(String contatoPessoal) {
        this.contatoPessoal = contatoPessoal;
    }

    public String getContatoConfianca() {
        return contatoConfianca;
    }

    public void setContatoConfianca(String contatoConfianca) {
        this.contatoConfianca = contatoConfianca;
    }
}
