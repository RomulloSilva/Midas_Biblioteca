package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.AuthorsValidations;
import com.envioemail.producerfila.exception.AuthorException;
import com.envioemail.producerfila.model.dto.Author;
import com.envioemail.producerfila.model.entitys.AuthorsEntity;
import com.envioemail.producerfila.repository.AuthorsRepository;
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
                throw new AuthorException("Author não encontrado!!");
            }
        } catch (Exception exception) {
            throw new AuthorException("Falha na busca pelo Author: " + exception);
        }
    }
//Integer changedLine;


}
