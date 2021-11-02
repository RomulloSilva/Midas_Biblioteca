package com.midaslibrary.managerLibrary.domain.impl;


import com.midaslibrary.managerLibrary.domain.interfaces.BookPropertiesValidations;
import com.midaslibrary.managerLibrary.exception.BookPropertiesException;
import com.midaslibrary.managerLibrary.model.dto.BookProperties;
import com.midaslibrary.managerLibrary.model.entities.BookPropertiesEntity;
import com.midaslibrary.managerLibrary.repository.BookPropertiesRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

@Log4j2
@Component
public class BookPropertiesValidationsImpl implements BookPropertiesValidations {

    private final BookPropertiesRepository bookPropertiesRepository;

    @Autowired
    public BookPropertiesValidationsImpl(BookPropertiesRepository bookPropertiesRepository) {
        this.bookPropertiesRepository = bookPropertiesRepository;
    }

    @Override
    public BookPropertiesEntity execute(Integer bookId) {
        return getBookPropertiesByBookId(bookId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertProperties(BookProperties bookProperties) {
        try {
            bookPropertiesRepository.save(BookPropertiesEntity.of(bookProperties));
            return true;
        } catch (Exception exception) {
            throw new BookPropertiesException(" " + exception);
        }
    }

    @Override
    public Integer availableBook(Integer bookId) {

        try {
            return bookPropertiesRepository.bookAvailable(bookId);
        } catch (Exception exception) {
            throw new BookPropertiesException("Failed to validate the availability of the book: " + exception);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBookQuantityAvailable(Integer bookId) {
        try {
            bookPropertiesRepository.updateQuantityAvailable(bookId);
        } catch (Exception exception) {
            throw new BookPropertiesException("Unable to update book properties: " + exception);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bookQuantityAvailable(Integer bookId) {
        try {
            bookPropertiesRepository.quantityAvailable(bookId);
        } catch (Exception exception) {
            throw new BookPropertiesException("Unable to update book properties: " + exception);
        }
    }

    public BookPropertiesEntity getBookPropertiesByBookId(Integer bookId) {
        BookPropertiesEntity bookPropertiesEntity;
        try {
            bookPropertiesEntity = bookPropertiesRepository.getBookPropertiesById(bookId);
            if (nonNull(bookPropertiesEntity)) {
                return bookPropertiesEntity;
            } else {
                log.error("No book properties found.");
                return bookPropertiesEntity;
            }

        } catch (Exception exception) {
            throw new BookPropertiesException("Failed to return book properties: " + exception);
        }
    }
}
