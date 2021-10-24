package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.LoanValidation;
import com.envioemail.producerfila.exception.LoanException;
import com.envioemail.producerfila.model.dto.Loan;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;


@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class LoanService {

    private static String MSG_FAILURE = "Failure to confirm loan";
    private static String MSG_FAILURE_UPDATE = "Failure to update loan: %s";
    private static String MSG_FAILURE_CREATE_LOAN = "No loans found for this user.";

    private final LoanValidation loanValidation;
    private final BookPropertieService bookPropertieService;


    @Autowired
    public LoanService(LoanValidation loanValidation,
                       BookPropertieService bookPropertieService) {
        this.loanValidation = loanValidation;
        this.bookPropertieService = bookPropertieService;
    }


    public void confirmsTheLoan(Loan loan) {
        try {
            loanValidation.execute(loan);
            bookPropertieService.updateBookPropertie(loan.getBookId());
        } catch (Exception exception) {
            throw new LoanException(MSG_FAILURE + exception);
        }
    }

    public Loan updateLoan(Integer userId, Integer bookId) {
        Integer loanId;
        Loan loan;
        try {
            loanId = loanValidation.findLoanId(userId, bookId);
            loanValidation.closeLoan(loanId);
            loan = createLoan(userId, bookId);
            return loan;
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_UPDATE, exception));
        }
    }

    public Loan createLoan(Integer userId, Integer bookId) {
        Loan loan;
        try {
            loan = Loan.of(userId, bookId);
            confirmsTheLoan(loan);
            return loan;
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_CREATE_LOAN, exception));
        }
    }
}
