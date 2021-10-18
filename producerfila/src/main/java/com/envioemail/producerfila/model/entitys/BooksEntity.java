package com.envioemail.producerfila.model.entitys;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    @Column(name = "book_title", unique = true, nullable = false)
    private String bookTitle;

    @Column(name = " summary", unique = true, nullable = false)
    private String summary;

    @Column(name = "author_name", unique = true, nullable = false)
    private String authorName;

    @Column(name = "author_id", unique = true, nullable = false)
    private Integer authorId;

    @Column(name = "release_date", unique = true, nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "volume", unique = true, nullable = false)
    private Integer volume;

    @Column(name = "isbn", unique = true, nullable = false)
    private Integer isbn;

    @Column(name = "number_of_pages", unique = true, nullable = false)
    private Integer numberOfPages;

    @Column(name = "country", unique = true, nullable = false)
    private String country;

    @Column(name = "publishing_company", unique = true, nullable = false)
    private String publishingCompany;
}