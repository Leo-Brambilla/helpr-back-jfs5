package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Setor;
import javax.persistence.*;

@Entity
public class FuturoCandidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String nomeCompleto;

    @Column (unique = true ,nullable = false)
    String email;

    @Column (nullable = false, length = 120)
    String descricaoHabilidades;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Setor setor;


    public FuturoCandidato(){}

    public FuturoCandidato(Integer id, String nomeCompleto, String email, String descricaoHabilidades){
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.descricaoHabilidades = descricaoHabilidades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoHabilidades() {
        return descricaoHabilidades;
    }

    public void setDescricaoHabilidades(String descricaoHabilidades) {
        this.descricaoHabilidades = descricaoHabilidades;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}