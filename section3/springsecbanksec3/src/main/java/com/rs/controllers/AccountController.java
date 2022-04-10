package com.rs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccountDetails(String input){
        return "Here are the Account Details from DB";
    }
}
