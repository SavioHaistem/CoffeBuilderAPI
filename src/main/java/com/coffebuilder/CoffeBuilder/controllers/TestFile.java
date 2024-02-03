package com.coffebuilder.CoffeBuilder.controllers;
import com.coffebuilder.CoffeBuilder.services.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class TestFile {
    @GetMapping("/coffe")
    public ResponseEntity<String> getFileData() {
        File defaultPath = new File("");
        String archivePath = "src/main/resources/data/CoffeSave.csv";
        FileService fileService = new FileService(defaultPath.getPath() + archivePath);
        try {
            String response = fileService.readFile().getFirst();
            return new ResponseEntity<>(fileService.readFile().getFirst() + " " + defaultPath.getAbsoluteFile(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}