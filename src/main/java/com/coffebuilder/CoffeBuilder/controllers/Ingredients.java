package com.coffebuilder.CoffeBuilder.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ingredients {
    @GetMapping
    public ResponseEntity<String> getIngredients() {
        return new ResponseEntity<>("OK OU MAIS OU MENOS", HttpStatus.OK);
    }
}