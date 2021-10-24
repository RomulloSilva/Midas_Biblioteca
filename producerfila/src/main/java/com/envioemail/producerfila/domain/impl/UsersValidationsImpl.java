package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.UsersValidations;
import com.envioemail.producerfila.exception.UserException;
import com.envioemail.producerfila.model.dto.User;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertUser(User user) {
        try {
            usersRepository.save(UsersEntity.of(user));
            return true;
        } catch (Exception exception) {
            throw new UserException("Failed to save user: " + exception);
        }
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
