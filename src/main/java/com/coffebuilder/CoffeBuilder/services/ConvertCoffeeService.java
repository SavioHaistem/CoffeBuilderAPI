package com.coffebuilder.CoffeBuilder.services;

import com.coffebuilder.CoffeBuilder.entities.Coffee;
import com.coffebuilder.CoffeBuilder.enums.Ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertCoffeeService {
    public ConvertCoffeeService() {}

    public static Coffee createCoffee(String[] CoffeeSavedLine) {
        List<Ingredients> ingredients = new ArrayList<>();
        String name = CoffeeSavedLine[0];
        Arrays.stream(CoffeeSavedLine[1].split(" ")).toList().forEach(ingredient -> ingredients.add(Ingredients.valueOf(ingredient)));
        Double quantity = Double.valueOf(CoffeeSavedLine[2]);
        return new Coffee(name,ingredients,quantity);
    }
}
