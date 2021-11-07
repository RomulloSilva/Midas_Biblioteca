package com.midaslibrary.managerLibrary.domain.interfaces;


import com.midaslibrary.managerLibrary.model.dto.Book;
import com.midaslibrary.managerLibrary.model.entities.BooksEntity;
import org.springframework.stereotype.Component;

@Component
public interface BooksValidantions {

    BooksEntity execute(Integer bookId);

    Boolean insertBook(Book book);

    Boolean insertImageKey(String imageKey, Integer bookId);

    String getBookTitle(Integer bookId);
}
