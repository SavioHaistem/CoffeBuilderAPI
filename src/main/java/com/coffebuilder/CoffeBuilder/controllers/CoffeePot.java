package com.coffebuilder.CoffeBuilder.controllers;
import com.coffebuilder.CoffeBuilder.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/coffees")
public class CoffeePot {
    FileService fileService = new FileService();

    @RequestMapping("/")
    public ResponseEntity<?> getCoffeesContent() throws IOException {
        try {
            return new ResponseEntity<>(fileService.readFile().getFirst(), HttpStatus.OK);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}