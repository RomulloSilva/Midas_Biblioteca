package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.BooksValidantions;
import com.envioemail.producerfila.exception.BookException;
import com.envioemail.producerfila.model.dto.Book;
import com.envioemail.producerfila.model.entitys.BooksEntity;
import com.envioemail.producerfila.repository.BooksRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.nonNull;

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
                throw new BookException("Livro não encontrado.");
            }
        } catch (Exception exception) {
            throw new BookException("Falha na busca do livro: " + exception);
        }
    }
}
