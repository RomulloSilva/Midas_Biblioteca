package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.UsersValidations;
import com.envioemail.producerfila.model.dto.UserDto;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.model.requests.composite.UserRequest;
import com.envioemail.producerfila.model.requests.payload.PayloadUser;
import lombok.AllArgsConstructor;

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
