package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.BookPropertiesValidations;
import com.envioemail.producerfila.exception.BookPropertiesException;
import com.envioemail.producerfila.model.dto.BookProperties;
import com.envioemail.producerfila.model.entitys.BookPropertiesEntity;
import com.envioemail.producerfila.repository.BookPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

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
    public Boolean updateBookQuantityAvailable(Integer bookId) {
        try {
            bookPropertiesRepository.updateQuantityAvailable(bookId);
            return true;
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
                throw new BookPropertiesException("No book properties found.");
            }

        } catch (Exception exception) {
            throw new BookPropertiesException("Failed to return book properties: " + exception);
        }
    }
}
