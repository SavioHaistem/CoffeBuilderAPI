package com.coffebuilder.CoffeBuilder.controllers;
import com.coffebuilder.CoffeBuilder.entities.Coffee;
import com.coffebuilder.CoffeBuilder.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/coffees")
public class CoffeePot {

    @RequestMapping("/")
    public ResponseEntity<Coffee> getCoffeesContent() throws IOException {
        FileService fileService = new FileService();
        try {
            return new ResponseEntity<>(fileService.readFile().getFirst(), HttpStatus.OK);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>(new Coffee("Error",new ArrayList<>(),1.0),HttpStatus.NO_CONTENT);
        }
    }
}