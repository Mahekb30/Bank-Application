package com.example.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.dtos.LoanRequestDto;
import com.example.dtos.LoanResponseDto;
import com.example.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    // Creating a logger
    Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<List<LoanResponseDto>> getAllLoans() {
        logger.info("Getting all loans");
        List<LoanResponseDto> loans = loanService.getAllLoans();
        if (loans.size() <= 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> getLoanById(@PathVariable int id) {
        logger.info("Getting loan with id: {}", id);
        LoanResponseDto loan = loanService.getLoanById(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/customer/{id}")
    public ResponseEntity<LoanResponseDto> getLoanByCustomerId(@PathVariable int id) {
        logger.info("Getting loan with customer id: {}", id);
        LoanResponseDto loan = loanService.getLoanByCustomerId(id);
        if (loan != null) {
            return ResponseEntity.ok(loan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDto> updateLoan(@PathVariable int id, @RequestBody LoanRequestDto loan) {
        logger.info("Updating loan with id: {}", id);
        LoanResponseDto updatedLoan = loanService.updateLoan(id, loan);
        if (updatedLoan != null) {
            return ResponseEntity.ok(updatedLoan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable int id) {
        logger.info("Deleting loan with id: {}", id);
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}