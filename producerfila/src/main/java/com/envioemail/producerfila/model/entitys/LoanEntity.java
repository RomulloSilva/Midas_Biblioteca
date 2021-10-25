package com.envioemail.producerfila.model.entitys;


import com.envioemail.producerfila.model.dto.LoanDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loans_id", unique = true, nullable = false)
    private Integer loansId;

    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "users_id", nullable = false)
    private Integer usersId;

    @Column(name = "date_of_loan", nullable = false)
    private LocalDateTime dateOfLoans;

    @Column(name = "expiration_date", nullable = false)
    private LocalDateTime expirationDate;

    @Column(name = "expired", nullable = false)
    private String expiration;

    @Column(name = "active_loan", nullable = false)
    private String activeLoan;

    public static LoanEntity of(LoanDto loanDto) {
        return LoanEntity.builder()
                .bookId(loanDto.getBookId())
                .usersId(loanDto.getUsersId())
                .dateOfLoans(loanDto.getDateOfLoans())
                .expirationDate(loanDto.getExpirationDate())
                .expiration(loanDto.getExpiration())
                .activeLoan(loanDto.getActiveLoan())
                .build();
    }

}
