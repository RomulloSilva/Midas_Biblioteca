package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.dto.Loan;
import com.envioemail.producerfila.model.dto.adapter.Data;
import com.envioemail.producerfila.model.requests.LoanRequest;
import com.envioemail.producerfila.service.LoanService;
import com.envioemail.producerfila.service.LoanValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/midasBiblioteca")
public class LoanController {

    private static String MSG_SUCCESS = "%s loans were made";
    private static String MSG_FAILURE = "The loan could not be made: %s";

    private final LoanValidationService loanValidationService;
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanValidationService loanValidationService,
                          LoanService loanService) {
        this.loanValidationService = loanValidationService;
        this.loanService = loanService;
    }

    @PostMapping("/loans")
    public ResponseEntity<String> executeLoan(@RequestBody @Valid LoanRequest loanRequest) {
        Integer confirmLoan;
        try {
            confirmLoan = loanValidationService.executeLoans(loanRequest.getLoans());
            return new ResponseEntity<>(String.format(MSG_SUCCESS, confirmLoan), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(String.format(MSG_FAILURE, exception), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/loan/{userId}/books/{bookId}")
    public ResponseEntity<Object> updateLoan(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId) {
        Loan loan;
        try {
            loan = loanService.updateLoan(userId, bookId);
            return ResponseEntity.ok(new Data<Loan>(loan));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(Loan.builder().build());
        }
    }

}
