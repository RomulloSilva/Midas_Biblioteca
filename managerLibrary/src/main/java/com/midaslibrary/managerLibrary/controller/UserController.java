package com.midaslibrary.managerLibrary.controller;


import com.midaslibrary.managerLibrary.config.aws.s3.S3ClientTransferManagerService;
import com.midaslibrary.managerLibrary.model.dto.UserDto;
import com.midaslibrary.managerLibrary.model.dto.adapter.Data;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.model.request.composite.UserRequest;
import com.midaslibrary.managerLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.net.URI;

import static java.util.Objects.nonNull;


@RestController
@RequestMapping("/midasBiblioteca")
public class UserController {

    private final UserService userService;
    private final S3ClientTransferManagerService s3ClientTransferManagerService;

    private static final String MESSAGE_FAILURE_POST = "Failure to save book.";


    @Autowired
    public UserController(UserService userService, S3ClientTransferManagerService s3ClientTransferManagerService) {
        this.userService = userService;
        this.s3ClientTransferManagerService = s3ClientTransferManagerService;
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

    @PostMapping("/user-picture/{id}")
    public ResponseEntity<String> upload(@PathVariable("id") Integer userId, @RequestParam(name = "archive") MultipartFile multiPartFile) {
        URI uri;
        try {
            uri = s3ClientTransferManagerService.uploadPictureUser(userId, multiPartFile);
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failure in save picture of user");
        }
    }
}
