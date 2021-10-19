package com.envioemail.producerfila.mocks;

import com.envioemail.producerfila.model.entitys.BooksEntity;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class BooksEntityMock {

    private static final Integer ID = 1;
    private static final String BOOK_TITLE = "The Best Book";
    private static final String SUMMARY = "This is the best book in the world";
    private static final String AUTHOR_NAME = "The Best";
    private static final Integer AUTHOR_ID = 1;
    private static final LocalDate RELEASE_DATE = LocalDate.now();
    private static final Integer VOLUME = 1;
    private static final Integer ISBN = 1456987;
    private static final Integer NUMBER_OF_PAGES = 666;
    private static final String COUNTRY = "Brasil";
    private static final String PUBLISHING_COMPANNING = "Cia das Letras";

    private BooksEntityMock() {
    }

    public static BooksEntity getBookMock() {
        return BooksEntity.builder()
                .id(ID)
                .bookTitle(BOOK_TITLE)
                .summary(SUMMARY)
                .authorName(AUTHOR_NAME)
                .authorId(AUTHOR_ID)
                .releaseDate(RELEASE_DATE)
                .volume(VOLUME)
                .isbn(ISBN)
                .numberOfPages(NUMBER_OF_PAGES)
                .country(COUNTRY)
                .publishingCompany(PUBLISHING_COMPANNING)
                .build();
    }
}
