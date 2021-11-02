package com.midaslibrary.managerLibrary.domain.interfaces;


import com.midaslibrary.managerLibrary.model.dto.LoanDto;
import com.midaslibrary.managerLibrary.model.entities.LoanEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoanValidation {

    Boolean execute(LoanDto loanDto);

    Boolean userValidation(Integer userId);

    Boolean userValidationBook(Integer userId, Integer bookId);

    Boolean closeLoan(Integer loanId);

    Integer findLoanId(Integer userId, Integer bookId);

    LoanEntity findLoanActive(Integer userId, Integer bookId);

    List<LoanEntity> findAllLoansByUser(Integer userId);

    LoanEntity fingLoanById(Integer loanId);
}
