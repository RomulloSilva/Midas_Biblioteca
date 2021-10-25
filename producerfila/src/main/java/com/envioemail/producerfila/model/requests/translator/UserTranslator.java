package com.envioemail.producerfila.model.requests.translator;

import com.envioemail.producerfila.model.entitys.LoanEntity;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.model.requests.composite.user.Loan;
import com.envioemail.producerfila.model.requests.composite.user.User;
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
