package com.envioemail.producerfila.mocks;

import com.envioemail.producerfila.model.entitys.UsersEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsersEntityMock {

    private static final Integer ID = 1;
    private static final String FIRST_NAME = "Manuel";
    private static final String LAST_NAME = "Barroso Fernandes";
    private static final String EMAIL = "barroso@gmail.com";
    private static final LocalDate BIRTH_DATE = LocalDate.now();
    private static final LocalDateTime VISITED_AT = LocalDateTime.now();
    private static final String PHONE = "11 945899625";

    private UsersEntityMock() {
    }

    public static UsersEntity getUserMock() {
        return UsersEntity.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastname(LAST_NAME)
                .email(EMAIL)
                .birthDate(BIRTH_DATE)
                .visitedAt(VISITED_AT)
                .phone(PHONE).build();
    }
}
