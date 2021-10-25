package com.envioemail.producerfila.domain.impl;

import com.envioemail.producerfila.domain.interfaces.LoanValidation;
import com.envioemail.producerfila.exception.LoanException;
import com.envioemail.producerfila.model.dto.LoanDto;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import com.envioemail.producerfila.repository.LoanRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;


@Log4j2
@Component
public class LoanValidationImpl implements LoanValidation {

    private static String MSG_FAILURE_INSERT = "Loan Insertion Failed: %s";
    private static String MSG_FAILURE_FIND = "Loan Update Failed: %s";
    private static String MSG_FAILURE_CLOSE = "Loan Close Failed: %s";
    private static String MSG_FAILURE_FIND_ID = "Loan Find Id Failed: %s";

    private final LoanRepository loanRepository;


    @Autowired
    public LoanValidationImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    @Override
    public Boolean execute(LoanDto loanDto) {
        return insertNewLoan(loanDto);
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

    @Override
    public LoanEntity findLoanActive(Integer userId, Integer bookId) {
        try {
            return loanRepository.findLoanActive(userId, bookId).orElse(null);
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_FIND, exception));
        }
    }

    @Override
    public Integer findLoanId(Integer userId, Integer bookId) {
        try {
            return loanRepository.findLoanId(userId, bookId);
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_FIND_ID, exception));
        }
    }

    @Override
    public List<LoanEntity> findAllLoansByUser(Integer userId){
        final List<LoanEntity> loanEntities = loanRepository.findAllLoan(userId);
        return CollectionUtils.isEmpty(loanEntities) ? Collections.emptyList() : loanEntities;
    }

    @Override
    public Boolean closeLoan(Integer loanId) {
        try {
            return loanRepository.closeLoan(loanId) == 1;
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_CLOSE, exception));
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public Boolean insertNewLoan(LoanDto loanDto) {
        try {
            loanRepository.save(LoanEntity.of(loanDto));
            return true;
        } catch (Exception exception) {
            log.error(String.format(MSG_FAILURE_INSERT, exception));
            throw new LoanException(String.format(MSG_FAILURE_INSERT, exception));
        }
    }


}
