package com.coffebuilder.CoffeBuilder.controllers;
import com.coffebuilder.CoffeBuilder.entities.Coffee;
import com.coffebuilder.CoffeBuilder.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/coffees")
public class CoffeePot {

    @RequestMapping("/")
    public ResponseEntity<Coffee> getFileData() {
        File defaultPath = new File("");
        String archivePath = "src/main/resources/data/CoffeeSave.csv";
        FileService fileService = new FileService(defaultPath.getPath() + archivePath);
        return new ResponseEntity<>(fileService.getCoffeeContent(), HttpStatus.OK);
    }
}