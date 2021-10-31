package com.midaslibrary.managerLibrary.model.request.translator;


import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.model.request.composite.user.Loan;
import com.midaslibrary.managerLibrary.model.request.composite.user.User;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class UserTranslator {

    public static User from(UsersEntity usersEntity, List<Loan> loans){
        return User.builder()
                .id(usersEntity.getId())
                .firstName(usersEntity.getFirstName())
                .lastname(usersEntity.getLastname())
                .email(usersEntity.getEmail())
                .birthDate(usersEntity.getBirthDate())
                .visitedAt(usersEntity.getVisitedAt())
                .phone(usersEntity.getPhone())
                .loans(loans)
                .build();
    }
}
