package br.zom.zup.edu.revista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/tag")
public class RevistaTagController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private RevistaRepository revistaRepository;

    @PostMapping
    public ResponseEntity<Void> cadastraTag(@RequestBody @Valid TagRequest tagRequest, UriComponentsBuilder uri){
        Tag tag = tagRequest.toModel();
        tagRepository.save(tag);

        URI location = uri.path("/tag/{id}").buildAndExpand(tag.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/revista")
    public ResponseEntity<Void> cadastraRegista(@RequestBody @Valid RevistaRequest revistaRequest, UriComponentsBuilder uri){
        Revista revista = revistaRequest.toModel(tagRepository);
        revistaRepository.save(revista);

        URI location = uri.path("/tag/revista/{id}").buildAndExpand(revista.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
