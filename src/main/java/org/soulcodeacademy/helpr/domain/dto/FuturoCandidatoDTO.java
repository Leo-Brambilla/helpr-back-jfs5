package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.Setor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FuturoCandidatoDTO {
    @NotBlank(message = "O nome completo é obrigatório.")
    private String nomeCompleto;
    @NotBlank(message = "O email é obrigatório.")
    private String email;
    @NotBlank(message = "A descrição é obrigatória.")
    private String descricaoHabilidades;
    @NotNull(message = "O setor é obrigatório.")
    private Setor setor;

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
    public void setSetor(Setor setor){
        this.setor = setor;
    }
}