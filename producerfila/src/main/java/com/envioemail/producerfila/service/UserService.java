package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.UsersValidations;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersValidations usersValidations;

    @Autowired
    public UserService(UsersValidations usersValidations) {
        this.usersValidations = usersValidations;
    }

    public UsersEntity getUserById(Integer userId) {
        return usersValidations.execute(userId);
    }

}
