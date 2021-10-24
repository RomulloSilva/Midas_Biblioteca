package com.envioemail.producerfila.model.dto;


import com.envioemail.producerfila.config.validators.SafeTextValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {


    private static final long serialVersionUID = -1365160347130164922L;

    @NotBlank(message = "Book title cannot be blank")
    @NotNull(message = "Book title cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String bookTitle;

    @NotBlank(message = "Summary cannot be blank")
    @NotNull(message = "Summary cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String summary;

    @NotBlank(message = "Author's name cannot be blank")
    @NotNull(message = "Author's name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String authorName;


    @NotNull(message = "Author's id cannot be null")
    private Integer authorId;


    @NotNull(message = "Release date cannot be null")
    private LocalDate releaseDate;


    @NotNull(message = "Volume cannot be null")
    private Integer volume;


    @NotNull(message = "ISBN cannot be null")
    private Integer isbn;


    @NotNull(message = "Number of pages cannot be null")
    private Integer numberOfPages;

    @NotBlank(message = "Country cannot be blank")
    @NotNull(message = "Country cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String country;

    @NotBlank(message = "Publishing company cannot be blank")
    @NotNull(message = "Publishing company cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String publishingCompany;
}
