package com.rs.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by rs 4/7/2022.
 */
@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getNotices(String input) {
        return "Here are the notices details from the DB";
    }
}
