package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.dto.Author;
import com.envioemail.producerfila.model.dto.adapter.Data;
import com.envioemail.producerfila.model.entitys.AuthorsEntity;
import com.envioemail.producerfila.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/midasBiblioteca")
public class AuthorController {

    private final AuthorService authorService;

    private static final String MESSAGE_FAILURE_POST = "Failure to save author.";

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

    @PostMapping("/author")
    public ResponseEntity<Object> insertAuthor(@RequestBody @Valid Author author) {
        if (authorService.insertAuthor(author)) {
            return ResponseEntity.ok(new Data<Author>(author));
        }
        return new ResponseEntity<>(MESSAGE_FAILURE_POST, HttpStatus.BAD_REQUEST);
    }
}
