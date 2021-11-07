package com.midaslibrary.managerLibrary.domain.impl;


import com.midaslibrary.managerLibrary.domain.interfaces.UsersValidations;
import com.midaslibrary.managerLibrary.exception.UserException;
import com.midaslibrary.managerLibrary.model.dto.UserDto;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.repository.UsersRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Log4j2
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
    public Boolean insertUser(UserDto userDto) {
        try {
            usersRepository.save(UsersEntity.of(userDto));
            return true;
        } catch (Exception exception) {
            throw new UserException("Failed to save user: " + exception);
        }
    }

    @Override
    public String getUserFirstName(Integer userId){
        try{
            return usersRepository.getUserName(userId).orElse(null);
        }catch (Exception exception){
            log.error("Failed to find user first name: " + exception);
            throw new UserException("Failed to find user first name: " + exception);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertImageKey(String imageKey, Integer userId){
        try {
            usersRepository.setImageKey(userId, imageKey);
            return true;
        } catch (Exception exception) {
            throw new UserException("Failed to save a imageKey: " + exception);
        }
    }


    public UsersEntity getUserById(Integer userId) {

        UsersEntity usersEntity = new UsersEntity();
        try {
            usersEntity = usersRepository.getUserByID(userId);
            if (nonNull(usersEntity)) {
                return usersEntity;
            } else {
                log.error("User not found.");
                return usersEntity;
            }
        } catch (Exception exception) {
            throw new UserException("User search failed: " + exception);
        }
    }
}
