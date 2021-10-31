package com.midaslibrary.managerLibrary.domain.impl;


import com.midaslibrary.managerLibrary.domain.interfaces.BooksValidantions;
import com.midaslibrary.managerLibrary.exception.BookException;
import com.midaslibrary.managerLibrary.model.dto.Book;
import com.midaslibrary.managerLibrary.model.entities.BooksEntity;
import com.midaslibrary.managerLibrary.repository.BooksRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Log4j2
@Component
public class BooksValidantionsImpl implements BooksValidantions {

    private final BooksRepository booksRepository;

    public BooksValidantionsImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public BooksEntity execute(Integer bookId) {
        return getBookById(bookId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertBook(Book book) {
        try {
            booksRepository.save(BooksEntity.of(book));
            return true;
        } catch (Exception exception) {
            throw new BookException("Unable to save book" + exception);
        }

    }

    public BooksEntity getBookById(Integer bookId) {
        BooksEntity booksEntity = new BooksEntity();
        try {
            booksEntity = booksRepository.getBookById(bookId);
            if (nonNull(booksEntity)) {
                return booksEntity;
            } else {
                log.error("Book not found for id: " + bookId);
                return booksEntity;
            }
        } catch (Exception exception) {
            throw new BookException("Failed to find the book: " + exception);
        }
    }
}
