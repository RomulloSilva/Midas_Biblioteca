package com.midaslibrary.managerLibrary.domain.interfaces;


import com.midaslibrary.managerLibrary.model.dto.Author;
import com.midaslibrary.managerLibrary.model.entities.AuthorsEntity;

public interface AuthorsValidations {

    AuthorsEntity execute(Integer authorID);

    Boolean insertAuthor(Author author);
}
