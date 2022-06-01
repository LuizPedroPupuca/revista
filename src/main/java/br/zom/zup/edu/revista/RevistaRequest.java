package br.zom.zup.edu.revista;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class RevistaRequest {

    @NotBlank
    @Size(max = 120)
    private String titulo;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotEmpty
    private Set<Long> idTags;

    public RevistaRequest(String titulo, LocalDate dataPublicacao, Set<Long> idTags) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.idTags = idTags;
    }

    public RevistaRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Set<Long> getIdTags() {
        return idTags;
    }

    public Revista toModel(TagRepository tagRepository) {
        Set<Tag> tags = idTags.stream().map(idTags -> tagRepository
                .findById(idTags).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag não encontrada")))
                .collect(Collectors.toSet());

        return new Revista(titulo, dataPublicacao, tags);

    }
}
