package com.rs.controllers;

import com.rs.model.Cards;
import com.rs.model.Customer;
import com.rs.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        List<Cards> cards = cardsRepository.findByEmail(customer.getEmail());
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }
}
