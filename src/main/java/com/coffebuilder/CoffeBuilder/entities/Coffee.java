package com.coffebuilder.CoffeBuilder.entities;

import com.coffebuilder.CoffeBuilder.enums.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String name;
    private List<Ingredients> ingredients = new ArrayList<>();
    private Double quantity;

    public Coffee(String name, List<Ingredients> ingredients, Double quantity) {
        this.name = name;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
