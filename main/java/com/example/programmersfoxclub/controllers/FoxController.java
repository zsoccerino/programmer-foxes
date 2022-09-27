package com.example.programmersfoxclub.controllers;

import com.example.programmersfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FoxController {

    private final FoxService service;

    @Autowired
    public FoxController(FoxService service) {
        this.service = service;
    }

    @PostMapping("/nutritionstore")
    public String loadNutritionStore(@RequestParam(name = "name", defaultValue = "the default fox") String name,
                                     @ModelAttribute(name = "food") String food,
                                     @ModelAttribute(name = "drink") String drink) {
        service.getFoxByName(name).setFood(food);
        service.getFoxByName(name).setDrink(drink);
        return "redirect:/?name=" + name;
    }

    @PostMapping("/trickcenter")
    public String loadTrickCenter(@RequestParam(name = "name", defaultValue = "the default fox") String name,
                                     @ModelAttribute(name = "trick") String trick) {
        service.getFoxByName(name).addTrick(trick);
        return "redirect:/?name=" + name;
    }
}
