package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.entitys.BooksEntity;
import com.envioemail.producerfila.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/midasBiblioteca")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BooksEntity> getBookById(@PathVariable("id") Integer bookId) {
        BooksEntity booksEntity;
        booksEntity = bookService.getBookById(bookId);
        if (nonNull(booksEntity)) {
            return ResponseEntity.ok(booksEntity);
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}
