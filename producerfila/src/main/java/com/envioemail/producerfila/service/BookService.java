package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.BookPropertiesValidations;
import com.envioemail.producerfila.domain.interfaces.BooksValidantions;
import com.envioemail.producerfila.model.entitys.BookPropertiesEntity;
import com.envioemail.producerfila.model.entitys.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BooksValidantions booksValidantions;
    private final BookPropertiesValidations bookPropertiesValidations;

    @Autowired
    public BookService(BooksValidantions booksValidantions,
                       BookPropertiesValidations bookPropertiesValidations) {
        this.booksValidantions = booksValidantions;
        this.bookPropertiesValidations = bookPropertiesValidations;
    }


    public BooksEntity getBookById(Integer bookId) {
        return booksValidantions.execute(bookId);
    }

    public BookPropertiesEntity getPropertiesById(Integer bookId) {
        return bookPropertiesValidations.execute(bookId);
    }
}
