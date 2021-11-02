package com.midaslibrary.managerLibrary.service;


import com.midaslibrary.managerLibrary.domain.interfaces.BookPropertiesValidations;
import com.midaslibrary.managerLibrary.model.dto.BookProperties;
import com.midaslibrary.managerLibrary.model.entities.BookPropertiesEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class BookPropertieService {

    private final BookPropertiesValidations bookPropertiesValidations;

    @Autowired
    public BookPropertieService(BookPropertiesValidations bookPropertiesValidations) {
        this.bookPropertiesValidations = bookPropertiesValidations;
    }


    public BookPropertiesEntity getPropertiesById(Integer bookId) {
        return bookPropertiesValidations.execute(bookId);
    }

    public Boolean insertNewBookProperties(BookProperties bookProperties) {
        return bookPropertiesValidations.insertProperties(bookProperties);
    }

    public void updateBookPropertiesQuantityBorrowed(Integer bookId) {
        bookPropertiesValidations.updateBookQuantityAvailable(bookId);
    }

    public void updateBookPropertieQuantityAvaliable(Integer bookId) {
        bookPropertiesValidations.bookQuantityAvailable(bookId);
    }
}
