package com.midaslibrary.managerLibrary.controller;


import com.midaslibrary.managerLibrary.model.dto.LoanDto;
import com.midaslibrary.managerLibrary.model.dto.adapter.Data;
import com.midaslibrary.managerLibrary.model.entities.LoanEntity;
import com.midaslibrary.managerLibrary.model.request.LoanRequest;
import com.midaslibrary.managerLibrary.service.LoanService;
import com.midaslibrary.managerLibrary.service.LoanValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/midasBiblioteca")
public class LoanController {

    private static final String MSG_SUCCESS = "%s loans were made";
    private static final String MSG_FAILURE = "The loan could not be made: %s";

    private final LoanValidationService loanValidationService;
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanValidationService loanValidationService,
                          LoanService loanService) {
        this.loanValidationService = loanValidationService;
        this.loanService = loanService;
    }

    @PostMapping("/loans-create")
    public ResponseEntity<String> executeLoan(@RequestBody @Valid LoanRequest loanRequest) {
        Integer confirmLoan;
        try {
            confirmLoan = loanValidationService.executeLoans(loanRequest.getLoanDtos());
            return new ResponseEntity<>(String.format(MSG_SUCCESS, confirmLoan), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(String.format(MSG_FAILURE, exception), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/loan-renovation/{userId}/books/{bookId}")
    public ResponseEntity<Object> updateLoan(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId) {
        LoanDto loanDto;
        try {
            loanDto = loanService.updateLoan(userId, bookId);
            return ResponseEntity.ok(new Data<LoanDto>(loanDto));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("It was no possible renew the loan.");
        }
    }

    @PutMapping("/loan-shutdown/{userId}/books/{bookId}")
    public ResponseEntity<Object> closeLoan(@PathVariable("userId") Integer userId, @PathVariable("bookId") Integer bookId) {
        LoanEntity loanEntity;
        try {
            loanEntity = loanService.closeLoan(userId, bookId);
            return ResponseEntity.ok(new Data<LoanEntity>(loanEntity));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("It was not possible to close the loan.");
        }
    }

}
