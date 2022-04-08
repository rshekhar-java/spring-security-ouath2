package com.rs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class CardController {

    @GetMapping("/myCards")
    public String getCardDetails(String input) {
        return "Here are the card details from the DB";
    }
}
