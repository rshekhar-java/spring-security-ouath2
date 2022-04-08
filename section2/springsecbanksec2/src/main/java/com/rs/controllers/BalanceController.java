package com.rs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetails(String input){
        return "Here are the balance details from db";
      }
}
