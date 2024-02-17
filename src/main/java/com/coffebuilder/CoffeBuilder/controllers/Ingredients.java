package com.coffebuilder.CoffeBuilder.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ingredients {
    @GetMapping("ingredients");
    public ResponseEntity<> getIngredients() {
        return
    }
}
