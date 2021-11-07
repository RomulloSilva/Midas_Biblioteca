package com.midaslibrary.managerLibrary.service;


import com.midaslibrary.managerLibrary.domain.interfaces.UsersValidations;
import com.midaslibrary.managerLibrary.exception.UserException;
import com.midaslibrary.managerLibrary.model.dto.UserDto;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.model.request.composite.UserRequest;
import com.midaslibrary.managerLibrary.model.request.payload.PayloadUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;


@Service
public class UserService {

    private final UsersValidations usersValidations;
    private final PayloadUser payloadUser;


    @Autowired
    public UserService(UsersValidations usersValidations,
                       PayloadUser payloadUser) {
        this.usersValidations = usersValidations;
        this.payloadUser = payloadUser;
    }


    public UsersEntity getUserById(Integer userId) {
        return usersValidations.execute(userId);
    }

    public Boolean InsertNewUser(UserDto userDto) {
        return usersValidations.insertUser(userDto);
    }

    public UserRequest getDataCompleteUser(Integer userId) {
        return payloadUser.geraPayloadUser(userId);
    }

    public String getUserFirstName(Integer userId) {
        String userFirstName;
        try {
            userFirstName = usersValidations.getUserFirstName(userId);
            if (nonNull(userFirstName)) {
                return userFirstName;
            } else {
                throw new UserException("User first name is null.");
            }
        } catch (Exception exception) {
            throw new UserException("Failed to find user first name: " + exception);
        }

    }

    public boolean setImageKey(String imageKey, Integer userId) {
        return usersValidations.insertImageKey(imageKey, userId);
    }
}
