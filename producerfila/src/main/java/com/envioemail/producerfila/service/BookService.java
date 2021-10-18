package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.BooksValidantions;
import com.envioemail.producerfila.model.entitys.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BooksValidantions booksValidantions;

    @Autowired
    public BookService(BooksValidantions booksValidantions) {
        this.booksValidantions = booksValidantions;
    }


    public BooksEntity getBookById(Integer bookId) {
        return booksValidantions.execute(bookId);
    }
}
