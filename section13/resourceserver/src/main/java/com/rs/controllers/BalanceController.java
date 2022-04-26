package com.rs.controllers;

import com.rs.model.AccountTransactions;
import com.rs.model.Customer;
import com.rs.repositories.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByEmailOrderByTransactionDtDesc(customer.getEmail());
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}
