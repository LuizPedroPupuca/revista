package br.zom.zup.edu.revista;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToMany
    private Set<Tag> tags;

    public Revista(String titulo, LocalDate dataPublicacao, Set<Tag> tags) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.tags = tags;
    }

    @Deprecated
    public Revista() {
    }

    public Long getId() {
        return id;
    }
}
