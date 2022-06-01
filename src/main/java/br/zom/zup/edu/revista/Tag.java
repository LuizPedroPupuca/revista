package br.zom.zup.edu.revista;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Tag(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Tag() {
    }

    public Long getId() {
        return id;
    }
}
