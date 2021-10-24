package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.LoanValidation;
import com.envioemail.producerfila.exception.LoanException;
import com.envioemail.producerfila.model.dto.Loan;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import com.envioemail.producerfila.repository.LoanRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Component
public class LoanValidationImpl implements LoanValidation {

    private static String MSG_FAILURE_INSERT = "Loan Insertion Failed: %s";

    private final LoanRepository loanRepository;


    @Autowired
    public LoanValidationImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    @Override
    public Boolean execute(Loan loan) {
        return insertNewLoan(loan);
    }


    @Override
    public Boolean userValidation(Integer userId) {

        try {
            return loanRepository.userWithExpiration(userId) <= 0;
        } catch (Exception exception) {
            throw new LoanException("Unable to validate user: " + exception);
        }
    }


    @Override
    public Boolean userValidationBook(Integer userId, Integer bookId) {
        try {
            return loanRepository.userAlreadyLentThisBook(userId, bookId) <= 0;
        } catch (Exception exception) {
            throw new LoanException("Unable to validate if user has active lending for this book: " + exception);
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public Boolean insertNewLoan(Loan loan) {
        try {
            loanRepository.save(LoanEntity.of(loan));
            return true;
        } catch (Exception exception) {
            log.error(String.format(MSG_FAILURE_INSERT, exception));
            throw new LoanException(String.format(MSG_FAILURE_INSERT, exception));
        }
    }
}
