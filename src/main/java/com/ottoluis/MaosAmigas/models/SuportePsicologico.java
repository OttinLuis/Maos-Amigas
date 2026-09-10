package com.ottoluis.MaosAmigas.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "suporte_psicologico_tb")
public class SuportePsicologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Column(name = "nome_psicologa", nullable = false)
    private String nomePsicologa;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Column(name = "crp", nullable = false, unique = true)
    private String crp;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Column(name = "especialidade")
    private String especialidade;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Column(name = "sobre_mim", columnDefinition = "TEXT")
    private String sobreMim;

    @Column(name = "contato_psicologa", nullable = false)
    private String contatoPsicologa;

    @NotBlank(message = "esse campo não pode ser vazio")
    @Email(message = "Email inválido")
    @Column(name = "email_psicologa", unique = true, nullable = false)
    private String emailPsicologa;

    @Column(name = "rede_social")
    private String redeSocial;

    private String imgUrl;

    public SuportePsicologico(){

    }

    public SuportePsicologico(Long id, String nomePsicologa, String crp, String especialidade, String sobreMim, String contatoPsicologa, String emailPsicologa, String redeSocial, String imgUrl) {
        this.id = id;
        this.nomePsicologa = nomePsicologa;
        this.crp = crp;
        this.especialidade = especialidade;
        this.sobreMim = sobreMim;
        this.contatoPsicologa = contatoPsicologa;
        this.emailPsicologa = emailPsicologa;
        this.redeSocial = redeSocial;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePsicologa() {
        return nomePsicologa;
    }

    public void setNomePsicologa(String nomePsicologa) {
        this.nomePsicologa = nomePsicologa;
    }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSobreMim() {
        return sobreMim;
    }

    public void setSobreMim(String sobreMim) {
        this.sobreMim = sobreMim;
    }

    public String getContatoPsicologa() {
        return contatoPsicologa;
    }

    public void setContatoPsicologa(String contatoPsicologa) {
        this.contatoPsicologa = contatoPsicologa;
    }

    public String getEmailPsicologa() {
        return emailPsicologa;
    }

    public void setEmailPsicologa(String emailPsicologa) {
        this.emailPsicologa = emailPsicologa;
    }

    public String getRedeSocial() {
        return redeSocial;
    }

    public void setRedeSocial(String redeSocial) {
        this.redeSocial = redeSocial;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        SuportePsicologico that = (SuportePsicologico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
