package com.envioemail.producerfila.model.entitys;


import com.envioemail.producerfila.model.dto.Loan;
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

    public static LoanEntity of(Loan loan) {
        return LoanEntity.builder()
                .bookId(loan.getBookId())
                .usersId(loan.getUsersId())
                .dateOfLoans(loan.getDateOfLoans())
                .expirationDate(loan.getExpirationDate())
                .expiration(loan.getExpiration())
                .activeLoan(loan.getActiveLoan())
                .build();
    }

}
