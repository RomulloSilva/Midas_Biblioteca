package com.midaslibrary.managerLibrary.domain.interfaces;


import com.midaslibrary.managerLibrary.model.dto.BookProperties;
import com.midaslibrary.managerLibrary.model.entities.BookPropertiesEntity;
import org.springframework.stereotype.Component;

@Component
public interface BookPropertiesValidations {

    BookPropertiesEntity execute(Integer bookId);

    Boolean insertProperties(BookProperties bookProperties);

    Integer availableBook(Integer bookId);

    Boolean updateBookQuantityAvailable(Integer bookId);
}
