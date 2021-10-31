package com.midaslibrary.managerLibrary.domain.impl;


import com.midaslibrary.managerLibrary.domain.interfaces.AuthorsValidations;
import com.midaslibrary.managerLibrary.exception.AuthorException;
import com.midaslibrary.managerLibrary.model.dto.Author;
import com.midaslibrary.managerLibrary.model.entities.AuthorsEntity;
import com.midaslibrary.managerLibrary.repository.AuthorsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Log4j2
@Component
public class AuthorsValidationsImpl implements AuthorsValidations {

    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsValidationsImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    @Override
    public AuthorsEntity execute(Integer authorID) {
        return findById(authorID);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertAuthor(Author author) {
        try {
            authorsRepository.save(AuthorsEntity.of(author));
            return true;
        } catch (Exception exception) {
            throw new AuthorException("Unable to save author: " + exception);
        }


    }

    public AuthorsEntity findById(Integer authorID) {

        AuthorsEntity author = new AuthorsEntity();
        try {
            author = authorsRepository.getAuthorById(authorID);
            if (nonNull(author)) {
                return author;
            } else {
                log.error("Author not found!!");
                return author;
            }
        } catch (Exception exception) {
            throw new AuthorException("Failed to find the author: " + exception);
        }
    }

}
