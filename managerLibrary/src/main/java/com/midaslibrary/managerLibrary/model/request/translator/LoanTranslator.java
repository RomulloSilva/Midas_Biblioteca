package com.midaslibrary.managerLibrary.model.request.translator;


import com.midaslibrary.managerLibrary.model.entities.LoanEntity;
import com.midaslibrary.managerLibrary.model.request.composite.user.Loan;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class LoanTranslator {

    public static List<Loan> fromList(List<LoanEntity> loanEntity) {
        List<Loan> loans = new ArrayList<>();
        Loan loan;
        for (LoanEntity loan1 : loanEntity) {
            loan = from(loan1);
            loans.add(loan);
        }
        return loans;
    }

    public static Loan from(LoanEntity loanEntity) {
        return Loan.builder()
                .loansId(loanEntity.getLoansId())
                .usersId(loanEntity.getUsersId())
                .bookId(loanEntity.getBookId())
                .dateOfLoans(loanEntity.getDateOfLoans())
                .expirationDate(loanEntity.getExpirationDate())
                .expiration(loanEntity.getExpiration())
                .activeLoan(loanEntity.getActiveLoan())
                .build();
    }
}
