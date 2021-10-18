package com.envioemail.producerfila.mocks;

import com.envioemail.producerfila.model.entitys.AuthorsEntity;

public class AuthorsEntityMock {

    private static final Integer ID = 1;
    private static final String FIRST_NAME = "";
    private static final String LAST_NAME = "";

    private AuthorsEntityMock() {
    }

    public static AuthorsEntity getAuthorMock() {
        return AuthorsEntity.builder()
                .id(ID)
                .authorFirstName(FIRST_NAME)
                .authorLastName(LAST_NAME).build();
    }
}
