package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.BookPropertiesValidations;
import com.envioemail.producerfila.domain.interfaces.BooksValidantions;
import com.envioemail.producerfila.exception.BookPropertiesException;
import com.envioemail.producerfila.model.dto.Book;
import com.envioemail.producerfila.model.dto.BookProperties;
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

    public Boolean insertNewBook(Book book) {
        return booksValidantions.insertBook(book);
    }


    public Boolean bookAvailable(Integer bookId) {

        if (bookPropertiesValidations.availableBook(bookId) > 0) {
            return true;
        } else {
            throw new BookPropertiesException("Book not available.");
        }
    }

    public BookPropertiesEntity getPropertiesById(Integer bookId) {
        return bookPropertiesValidations.execute(bookId);
    }
    public Boolean insertNewBookProperties(BookProperties bookProperties) {
        return bookPropertiesValidations.insertProperties(bookProperties);
    }
}
