package com.midaslibrary.managerLibrary.service;


import com.midaslibrary.managerLibrary.domain.interfaces.AuthorsValidations;
import com.midaslibrary.managerLibrary.model.dto.Author;
import com.midaslibrary.managerLibrary.model.entities.AuthorsEntity;
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

    public Boolean insertAuthor(Author author) {
        return authorsValidations.insertAuthor(author);
    }


}
