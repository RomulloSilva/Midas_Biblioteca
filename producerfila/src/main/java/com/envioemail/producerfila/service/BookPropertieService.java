package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.BookPropertiesValidations;
import com.envioemail.producerfila.model.dto.BookProperties;
import com.envioemail.producerfila.model.entitys.BookPropertiesEntity;
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

    public Boolean updateBookPropertie(Integer bookId) {
        return bookPropertiesValidations.updateBookQuantityAvailable(bookId);
    }
}
