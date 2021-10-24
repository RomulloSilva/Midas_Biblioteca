package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.entitys.BookPropertiesEntity;
import org.springframework.stereotype.Component;

@Component
public interface BookPropertiesValidations {

    BookPropertiesEntity execute(Integer bookId);
}
