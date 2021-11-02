package com.midaslibrary.managerLibrary.controller;


import com.midaslibrary.managerLibrary.mocks.BooksEntityMock;
import com.midaslibrary.managerLibrary.model.entities.BooksEntity;
import com.midaslibrary.managerLibrary.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;


public class BookControllerTest {

    private final BooksEntity booksEntityMock = BooksEntityMock.getBookMock();
    private final Integer bookId = 1;

    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void setClose() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Book search test by id, search success")
    public void getBookById_Sucess() {

        doReturn(booksEntityMock).when(bookService).getBookById(Mockito.anyInt());
        bookController = new BookController(bookService);
        assertThat(bookController.getBookById(bookId).equals(ResponseEntity.ok()));

    }

    @Test
    @DisplayName("Book search test by id, null result")
    public void getBookById_Null() {

        doReturn(null).when(bookService).getBookById(Mockito.anyInt());
        bookController = new BookController(bookService);
        assertThat(bookController.getBookById(bookId).equals(ResponseEntity.noContent()));

    }

}
