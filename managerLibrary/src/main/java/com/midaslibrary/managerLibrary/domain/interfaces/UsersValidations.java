package com.midaslibrary.managerLibrary.domain.interfaces;


import com.midaslibrary.managerLibrary.model.dto.UserDto;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public interface UsersValidations {

    UsersEntity execute(Integer userId);

    Boolean insertUser(UserDto userDto);

    String getUserFirstName(Integer userId);

    Boolean insertImageKey(String imageKey, Integer userId);

}
