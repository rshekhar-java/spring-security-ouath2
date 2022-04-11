package com.rs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class ContactController {
    @GetMapping("/contact")
    public String saveContactInquiryDetails(String input) {
        return "Inquiry details are saved to the DB";
    }
}
