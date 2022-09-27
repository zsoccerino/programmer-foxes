package com.example.programmersfoxclub.controllers;

import com.example.programmersfoxclub.models.Fox;
import com.example.programmersfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final FoxService service;

    @Autowired
    public MainController(FoxService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String loadHome(Model model, @RequestParam(name = "name", defaultValue = "the default fox") String name) {
        Fox fox = service.getFoxByName(name);
        model.addAttribute("name", name);
        model.addAttribute("food", fox.getFood());
        model.addAttribute("drink", fox.getDrink());
        model.addAttribute("numberOfTricks", fox.getListOfTricks().size());
        model.addAttribute("trickList", fox.getListOfTricks());
        return "index";
    }

    @GetMapping("/login")
    public String loadLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "name", defaultValue = "the default fox") String name) {
        service.addFox(name);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutritionstore")
    public String loadNutritionStore(Model model, @RequestParam(name = "name", defaultValue = "the default fox") String name) {
        model.addAttribute("name",name);
        return "nutritionstore";
    }

    @GetMapping("/trickcenter")
    public String loadTrickCenter(Model model, @RequestParam(name = "name", defaultValue = "the default fox") String name) {
        Fox fox = service.getFoxByName(name);
        model.addAttribute("name",name);
        model.addAttribute("trickList", fox.getListOfTricks());
        return "trickcenter";
    }
}
