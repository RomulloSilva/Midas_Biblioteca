package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.dto.LoanDto;
import com.envioemail.producerfila.model.entitys.LoanEntity;
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
}
