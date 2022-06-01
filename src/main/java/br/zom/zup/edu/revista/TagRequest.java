package br.zom.zup.edu.revista;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class TagRequest {

    @NotBlank
    private String nome;

    public TagRequest(String nome) {
        this.nome = nome;
    }

    public TagRequest() {
    }

    public String getNome() {
        return nome;
    }

    public Tag toModel() {
        return new Tag(nome);
    }
}
