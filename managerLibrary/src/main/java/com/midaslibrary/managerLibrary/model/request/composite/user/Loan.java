package com.midaslibrary.managerLibrary.model.request.composite.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    private Integer loansId;
    private Integer bookId;
    private Integer usersId;
    private LocalDateTime dateOfLoans;
    private LocalDateTime expirationDate;
    private String expiration;
    private String activeLoan;
}
