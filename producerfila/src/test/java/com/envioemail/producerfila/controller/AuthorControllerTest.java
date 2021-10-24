package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.mocks.AuthorsEntityMock;
import com.envioemail.producerfila.model.entitys.AuthorsEntity;
import com.envioemail.producerfila.service.AuthorService;
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

public class AuthorControllerTest {

    private final AuthorsEntity authorsEntityMock = AuthorsEntityMock.getAuthorMock();
    private final Integer authorId = 1;

    @InjectMocks
    AuthorController authorController;

    @Mock
    AuthorService authorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void setClose() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Author's request test by id, being successful in the search")
    public void getAuthorById_Sucess() {
        doReturn(authorsEntityMock).when(authorService).getAuthorById(Mockito.anyInt());
        authorController = new AuthorController(authorService);
        assertThat(authorController.getAuthorById(authorId).equals(ResponseEntity.ok()));
    }

    @Test
    @DisplayName("Author's test request by id, getting null result")
    public void getAuthorById_Null() {
        doReturn(null).when(authorService).getAuthorById(Mockito.anyInt());
        authorController = new AuthorController(authorService);
        assertThat(authorController.getAuthorById(authorId).equals(ResponseEntity.noContent()));
    }

}
