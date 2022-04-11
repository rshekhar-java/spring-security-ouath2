package com.rs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class LoansController {
    @GetMapping("/myLoans")
    public String getLoanDetails(String input) {
        return "Here are the loan details from the DB";
    }

}
