package com.envioemail.producerfila.domain.interfaces;


import com.envioemail.producerfila.model.dto.Author;
import com.envioemail.producerfila.model.entitys.AuthorsEntity;

public interface AuthorsValidations {

    AuthorsEntity execute(Integer authorID);

    Boolean insertAuthor(Author author);
}
