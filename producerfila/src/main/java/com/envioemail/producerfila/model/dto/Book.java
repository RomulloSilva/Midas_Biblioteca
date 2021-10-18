package com.envioemail.producerfila.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {


    private static final long serialVersionUID = -1365160347130164922L;
    private String bookTitle;
    private String summary;
    private String authorName;
    private Integer authorId;
    private LocalDateTime releaseDate;
    private Integer volume;
    private Integer isbn;
    private Integer numberOfPages;
    private String country;
    private String publishingCompany;
}
