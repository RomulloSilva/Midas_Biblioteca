package com.midaslibrary.managerLibrary.service;


import com.midaslibrary.managerLibrary.domain.interfaces.BookPropertiesValidations;
import com.midaslibrary.managerLibrary.domain.interfaces.BooksValidantions;
import com.midaslibrary.managerLibrary.exception.BookPropertiesException;
import com.midaslibrary.managerLibrary.exception.UserException;
import com.midaslibrary.managerLibrary.model.dto.Book;
import com.midaslibrary.managerLibrary.model.dto.BookProperties;
import com.midaslibrary.managerLibrary.model.entities.BookPropertiesEntity;
import com.midaslibrary.managerLibrary.model.entities.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

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

    public String getBookTitle(Integer bookId) {
        String bookTitle;
        try {
            bookTitle = booksValidantions.getBookTitle(bookId);
            if (nonNull(bookTitle)) {
                return bookTitle;
            } else {
                throw new UserException("Book title is null.");
            }
        } catch (Exception exception) {
            throw new UserException("Failed to find book title: " + exception);
        }

    }

    public boolean setImageKey(String imageKey, Integer bookId) {
        return booksValidantions.insertImageKey(imageKey, bookId);
    }

    public BookPropertiesEntity getPropertiesById(Integer bookId) {
        return bookPropertiesValidations.execute(bookId);
    }

    public Boolean insertNewBookProperties(BookProperties bookProperties) {
        return bookPropertiesValidations.insertProperties(bookProperties);
    }
}
