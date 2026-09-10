package com.ottoluis.MaosAmigas.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "role_tb")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autoritzacao; //authority

    public Role(){}

    public Role(Long id, String autoritzacao) {
        this.id = id;
        this.autoritzacao = autoritzacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutoritzacao() {
        return autoritzacao;
    }

    public void setAutoritzacao(String autoritzacao) {
        this.autoritzacao = autoritzacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}