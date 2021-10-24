package com.envioemail.producerfila.service;

import com.envioemail.producerfila.domain.interfaces.LoanValidation;
import com.envioemail.producerfila.exception.LoanException;
import com.envioemail.producerfila.model.dto.Loan;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Exception.class)
@Log4j2
@Service
public class LoanService {

    private static String MSG_FAILURE = "Failure to confirm loan";

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
}
