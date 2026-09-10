package com.ottoluis.MaosAmigas.models;

import com.ottoluis.MaosAmigas.models.embeddable.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario_tb")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Endereco endereco;

    @Column(unique = true, nullable = false, name = "cpf")
    @NotBlank(message = "esse campo não pode ser vazio")
    private String cpf;

    @Column(name = "nome", nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String email;

    @Column(name = "senha", nullable = false)
    @Size(min = 6, message = "esse campo precisa ter no minimo 6 caracteres")
    @NotBlank(message = "esse campo não pode ser vazio")
    private String senha;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @Column(name = "contato_pessoal", nullable = false)
    @NotBlank(message = "esse campo não pode ser vazio")
    private String contatoPessoal;

    @Column(name = "contato_confianca", nullable = false)
    private String contatoConfianca;



    public Usuario() {}

    public Usuario(Long id, String cpf, String nome, String email, String senha, String dataNascimento, Endereco endereco, String contatoPessoal, String contatoConfianca) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.contatoPessoal = contatoPessoal;
        this.contatoConfianca = contatoConfianca;
    }
    @ManyToMany
    @JoinTable(name = "usuario_role_tb",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

