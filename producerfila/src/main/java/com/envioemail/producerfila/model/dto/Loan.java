package com.envioemail.producerfila.model.dto;


import com.envioemail.producerfila.config.validators.SafeTextValidator;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Loan {


    @NotNull(message = "BookId cannot be null")
    private Integer bookId;

    @NotNull(message = "UsersId cannot be null")
    private Integer usersId;

    @NotNull(message = "DateOfLoans cannot be null")
    private LocalDateTime dateOfLoans;

    @NotNull(message = "ExpirationDate cannot be null")
    private LocalDateTime expirationDate;

    @Max(1)
    @SafeTextValidator(message = "Improper xss script detected.")
    private String expiration;

    @Max(1)
    @SafeTextValidator(message = "ActiveLoan xss script detected.")
    private String activeLoan;


    public static Loan of(Integer userId, Integer bookId){
        return Loan.builder()
                .bookId(bookId)
                .usersId(userId)
                .dateOfLoans(LocalDateTime.now())
                .expirationDate(LocalDateTime.now().plusDays(15))
                .expiration("0")
                .activeLoan("1")
                .build();
    }
}