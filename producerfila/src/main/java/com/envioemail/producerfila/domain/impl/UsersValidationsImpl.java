package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.UsersValidations;
import com.envioemail.producerfila.exception.UserException;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class UsersValidationsImpl implements UsersValidations {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersValidationsImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersEntity execute(Integer userId) {
        return getUserById(userId);
    }


    public UsersEntity getUserById(Integer userId) {

        UsersEntity usersEntity = new UsersEntity();
        try {
            usersEntity = usersRepository.getUserByID(userId);
            if (nonNull(usersEntity)) {
                return usersEntity;
            } else {
                throw new UserException("Usuário não encontrado.");
            }
        } catch (Exception exception) {
            throw new UserException("Falha na busca pelo usuário: " + exception);
        }
    }
}
