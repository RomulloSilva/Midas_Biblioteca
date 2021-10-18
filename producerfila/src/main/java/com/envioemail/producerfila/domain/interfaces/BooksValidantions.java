package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.entitys.BooksEntity;
import org.springframework.stereotype.Component;

@Component
public interface BooksValidantions {

    BooksEntity execute(Integer bookId);
}
