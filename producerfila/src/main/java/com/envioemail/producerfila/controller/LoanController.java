package com.envioemail.producerfila.controller;

import com.envioemail.producerfila.model.requests.LoanRequest;
import com.envioemail.producerfila.service.LoanValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/midasBiblioteca")
public class LoanController {

    private static String MSG_SUCCESS = "%s loans were made";
    private static String MSG_FAILURE = "The loan could not be made: %s";

    private final LoanValidationService loanValidationService;

    @Autowired
    public LoanController(LoanValidationService loanValidationService) {
        this.loanValidationService = loanValidationService;
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
}
