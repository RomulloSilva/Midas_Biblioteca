package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/midasBiblioteca")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UsersEntity> getUserById(@PathVariable("id") Integer userId) {
        UsersEntity usersEntity;
        usersEntity = userService.getUserById(userId);
        if (nonNull(usersEntity)) {
            return ResponseEntity.ok(usersEntity);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
