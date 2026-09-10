package com.ottoluis.MaosAmigas.models.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;


@Embeddable
public class Endereco {

    @Column(nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String rua;

    @Column(nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String numero;

    @Column(nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String bairro;

    @Column(nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String cidade;

    @Column(nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String estado;

    @Column(nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String cep;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String bairro,
                    String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}