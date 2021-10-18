package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.mocks.UsersEntityMock;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.service.UserService;
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

public class UserControllerTest {

    private final UsersEntity usersEntityMock = UsersEntityMock.getUserMock();
    private final Integer userId = 1;

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void setClose() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("User search test by id, search success")
    public void getUserById_Sucess() {

        doReturn(usersEntityMock).when(userService).getUserById(Mockito.anyInt());
        userController = new UserController(userService);
        assertThat(userController.getUserById(userId).equals(ResponseEntity.ok()));

    }

    @Test
    @DisplayName("User search test by id, null result")
    public void getUserById_Null() {

        doReturn(null).when(userService).getUserById(Mockito.anyInt());
        userController = new UserController(userService);
        assertThat(userController.getUserById(userId).equals(ResponseEntity.noContent()));

    }


}
