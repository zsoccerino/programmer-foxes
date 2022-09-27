package com.example.programmersfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {

    private String name;
    private List<String> listOfTricks = new ArrayList<>();
    private String food = "default food";
    private String drink = "default drink";

    public Fox() {
    }

    public Fox(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getListOfTricks() {
        return listOfTricks;
    }

    public void addTrick(String trick) {
        if (!this.listOfTricks.contains(trick)) {
            this.listOfTricks.add(trick);
        }
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
