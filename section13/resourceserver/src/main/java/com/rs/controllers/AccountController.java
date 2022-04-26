package com.rs.controllers;

import com.rs.model.Accounts;
import com.rs.model.Customer;
import com.rs.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer){

        Accounts accounts=accountRepository.findByEmail(customer.getEmail());
        if(accounts != null){
            return accounts;
        }else{
            return null;
        }
    }
}
