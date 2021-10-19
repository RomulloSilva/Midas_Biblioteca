package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.dto.Book;
import com.envioemail.producerfila.model.dto.adapter.Data;
import com.envioemail.producerfila.model.entitys.BookPropertiesEntity;
import com.envioemail.producerfila.model.entitys.BooksEntity;
import com.envioemail.producerfila.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/midasBiblioteca")
public class BookController {

    private final BookService bookService;

    private static final String MESSAGE_FAILURE_POST = "Failure to save book.";

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

    @GetMapping("/book/{id}/properties")
    public ResponseEntity<BookPropertiesEntity> getProperties(@PathVariable("id") Integer bookId) {
        BookPropertiesEntity bookPropertiesEntity;
        bookPropertiesEntity = bookService.getPropertiesById(bookId);
        if (nonNull(bookPropertiesEntity)) {
            return ResponseEntity.ok(bookPropertiesEntity);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Object> insertBook(@RequestBody @Valid Book book) {
        if (bookService.insertNewBook(book)) {
            return ResponseEntity.ok(new Data<Book>(book));
        }
        return new ResponseEntity<>(MESSAGE_FAILURE_POST, HttpStatus.BAD_REQUEST);
    }

}
