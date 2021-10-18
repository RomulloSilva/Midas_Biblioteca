package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.entitys.AuthorsEntity;
import com.envioemail.producerfila.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/midasBiblioteca")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<AuthorsEntity> getAuthorById(@PathVariable("id") Integer authorId) {
        AuthorsEntity author;

        author = authorService.getAuthorById(authorId);
        if (nonNull(author)) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}
