package com.envioemail.producerfila.domain.interfaces;

import com.envioemail.producerfila.model.dto.Loan;
import org.springframework.stereotype.Component;

@Component
public interface LoanValidation {

    Boolean execute(Loan loan);

    Boolean userValidation(Integer userId);

    Boolean userValidationBook(Integer userId, Integer bookId);
}
