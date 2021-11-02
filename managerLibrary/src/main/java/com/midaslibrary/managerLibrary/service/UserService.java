package com.midaslibrary.managerLibrary.service;


import com.midaslibrary.managerLibrary.domain.interfaces.UsersValidations;
import com.midaslibrary.managerLibrary.model.dto.UserDto;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.model.request.composite.UserRequest;
import com.midaslibrary.managerLibrary.model.request.payload.PayloadUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
