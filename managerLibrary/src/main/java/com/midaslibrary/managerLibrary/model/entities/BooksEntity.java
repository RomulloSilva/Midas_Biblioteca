package com.midaslibrary.managerLibrary.model.entities;


import com.midaslibrary.managerLibrary.model.dto.Book;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksEntity implements Serializable {

    private static final long serialVersionUID = 2367589194740367066L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "author_id", nullable = false)
    private Integer authorId;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "volume", nullable = false)
    private Integer volume;

    @Column(name = "isbn", unique = true, nullable = false)
    private Integer isbn;

    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "publishing_company", nullable = false)
    private String publishingCompany;

    @Column(name = "image_key")
    private String imageKey;

    public static BooksEntity of(Book book) {
        return BooksEntity.builder()
                .bookTitle(book.getBookTitle())
                .summary(book.getSummary())
                .authorName(book.getAuthorName())
                .authorId(book.getAuthorId())
                .releaseDate(book.getReleaseDate())
                .volume(book.getVolume())
                .isbn(book.getIsbn())
                .numberOfPages(book.getNumberOfPages())
                .country(book.getCountry())
                .publishingCompany(book.getPublishingCompany()).build();
    }
}