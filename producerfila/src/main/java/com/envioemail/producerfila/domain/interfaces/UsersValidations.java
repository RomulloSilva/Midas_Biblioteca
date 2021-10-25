package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.dto.UserDto;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public interface UsersValidations {

    UsersEntity execute(Integer userId);

    Boolean insertUser(UserDto userDto);

}
