package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.AuthorsValidations;
import com.envioemail.producerfila.model.entitys.AuthorsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorsValidations authorsValidations;

    @Autowired
    public AuthorService(AuthorsValidations authorsValidations) {
        this.authorsValidations = authorsValidations;
    }


    public AuthorsEntity getAuthorById(Integer authorId) {
        return authorsValidations.execute(authorId);
    }


}
