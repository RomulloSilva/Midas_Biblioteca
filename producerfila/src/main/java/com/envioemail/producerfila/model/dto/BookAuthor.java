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
public class BookAuthor implements Serializable {


    private static final long serialVersionUID = 6106274150720095593L;
    private Integer bookId;
    private String bookTitle;
    private String summary;
    private Integer volume;
    private LocalDateTime releaseDate;
    private String authorFirstName;
    private String authorLastName;
}
