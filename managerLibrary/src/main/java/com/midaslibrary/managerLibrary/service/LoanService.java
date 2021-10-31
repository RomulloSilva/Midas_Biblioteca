package com.midaslibrary.managerLibrary.service;


import com.midaslibrary.managerLibrary.domain.interfaces.LoanValidation;
import com.midaslibrary.managerLibrary.exception.LoanException;
import com.midaslibrary.managerLibrary.model.dto.LoanDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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


    public void confirmsTheLoan(LoanDto loanDto) {
        try {
            loanValidation.execute(loanDto);
            bookPropertieService.updateBookPropertie(loanDto.getBookId());
        } catch (Exception exception) {
            throw new LoanException(MSG_FAILURE + exception);
        }
    }

    public LoanDto updateLoan(Integer userId, Integer bookId) {
        Integer loanId;
        LoanDto loanDto;
        try {
            loanId = loanValidation.findLoanId(userId, bookId);
            loanValidation.closeLoan(loanId);
            loanDto = createLoan(userId, bookId);
            return loanDto;
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_UPDATE, exception));
        }
    }

    public LoanDto createLoan(Integer userId, Integer bookId) {
        LoanDto loanDto;
        try {
            loanDto = LoanDto.of(userId, bookId);
            confirmsTheLoan(loanDto);
            return loanDto;
        } catch (Exception exception) {
            throw new LoanException(String.format(MSG_FAILURE_CREATE_LOAN, exception));
        }
    }
}
