package com.rs.controllers;

import com.rs.model.Customer;
import com.rs.model.Loans;
import com.rs.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @PostMapping("/myLoans")
    @PostAuthorize("hasRole('ROOT')")
    public List<Loans> getLoanDetails(@RequestBody Customer customer) {
        List<Loans> loans = loanRepository.findByEmailOrderByStartDtDesc(customer.getEmail());
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
