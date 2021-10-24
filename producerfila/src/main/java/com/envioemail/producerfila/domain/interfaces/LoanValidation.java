package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.dto.Loan;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import org.springframework.stereotype.Component;

@Component
public interface LoanValidation {

    Boolean execute(Loan loan);

    Boolean userValidation(Integer userId);

    Boolean userValidationBook(Integer userId, Integer bookId);

    Boolean closeLoan(Integer loanId);

    Integer findLoanId(Integer userId, Integer bookId);

    LoanEntity findLoan(Integer userId, Integer bookId);
}
