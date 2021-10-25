package com.envioemail.producerfila.controller;


import com.envioemail.producerfila.model.dto.UserDto;
import com.envioemail.producerfila.model.dto.adapter.Data;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.model.requests.composite.UserRequest;
import com.envioemail.producerfila.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.util.Objects.nonNull;


@RestController
@RequestMapping("/midasBiblioteca")
public class UserController {

    private final UserService userService;

    private static final String MESSAGE_FAILURE_POST = "Failure to save book.";


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

    @GetMapping("/user/{id}/data")
    public ResponseEntity<Object> getDataUserComplete(@PathVariable("id") Integer userId) {
        UserRequest userRequest;
        userRequest = userService.getDataCompleteUser(userId);
        if (nonNull(userRequest)) {
            return ResponseEntity.ok(new Data<UserRequest>(userRequest));
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping("/user")
    public ResponseEntity<Object> insertNewUser(@RequestBody @Valid UserDto userDto) {
        if (userService.InsertNewUser(userDto)) {
            return ResponseEntity.ok(new Data<UserDto>(userDto));
        }
        return new ResponseEntity<>(MESSAGE_FAILURE_POST, HttpStatus.BAD_REQUEST);
    }
}
