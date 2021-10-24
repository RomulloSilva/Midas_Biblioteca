package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.LoanValidation;
import com.envioemail.producerfila.exception.BookException;
import com.envioemail.producerfila.exception.LoanException;
import com.envioemail.producerfila.exception.UserException;
import com.envioemail.producerfila.model.dto.Loan;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class LoanValidationService {

    private static String MSG_USER_WITH_EXPIRATION = "This user has expired loans.";
    private static String MSG_USER_ACTIVE_LOAN = "User has active loan for this book.";
    private static String MSG_FAILURE = "Failure to generate loan: %s";
    private static String MSG_SUCCESS = "Loan effected;";
    private Integer confirmLoan = 0;

    private final LoanValidation loanValidation;
    private final BookService bookService;
    private final LoanService loanService;

    @Autowired
    public LoanValidationService(LoanValidation loanValidation,
                                 BookService bookService,
                                 LoanService loanService) {
        this.loanValidation = loanValidation;
        this.bookService = bookService;
        this.loanService = loanService;
    }

    public Integer executeLoans(List<Loan> loans) {
        if (!loans.isEmpty()) {
            for (Loan loan : loans) {
                try {
                    userValidation(loan);
                } catch (Exception exception) {
                    log.error(String.format(MSG_FAILURE, exception));
                    throw new LoanException(String.format(MSG_FAILURE, exception));
                }
            }
        } else {
            throw new LoanException("Object loan is empty.");
        }
        return confirmLoan;
    }

    public void userValidation(Loan loan) {
        if (loanValidation.userValidation(loan.getUsersId())) {
            userActiveLoan(loan);
        } else {
            log.error(MSG_USER_WITH_EXPIRATION);
            throw new UserException(MSG_USER_WITH_EXPIRATION);
        }
    }


    public void userActiveLoan(Loan loan) {
        if (loanValidation.userValidationBook(loan.getUsersId(), loan.getBookId())) {
            bookValidation(loan);
        } else {
            log.error(MSG_USER_ACTIVE_LOAN);
            throw new BookException(MSG_USER_ACTIVE_LOAN);
        }
    }

    public void bookValidation(Loan loan) {
        try {
            bookService.bookAvailable(loan.getBookId());
            loanService.confirmsTheLoan(loan);
            confirmLoan++;
            log.info(MSG_SUCCESS);
        } catch (Exception exception) {
            log.error("Book Validation: " + exception);
            throw new BookException("Book Validation: " + exception);
        }
    }
}
