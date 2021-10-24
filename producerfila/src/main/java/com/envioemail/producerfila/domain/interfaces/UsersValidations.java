package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.dto.User;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import org.springframework.stereotype.Component;

@Component
public interface UsersValidations {

    UsersEntity execute(Integer userId);

    Boolean insertUser(User user);

}
