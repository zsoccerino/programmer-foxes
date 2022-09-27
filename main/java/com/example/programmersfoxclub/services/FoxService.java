package com.example.programmersfoxclub.services;

import com.example.programmersfoxclub.models.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxService {

    private final Fox defaultFox = new Fox("the default fox");
    private List<Fox> foxList = new ArrayList<>() {
        { add(defaultFox); }
    };

    public void addFox(String name) {
        Fox fox = new Fox(name);
        foxList.add(fox);
    }

    public Fox getFoxByName(String name) {
        for (Fox fox : foxList) {
            if (fox.getName().equals(name)) {
                return fox;
            }
        }
        return null;
    }

    public Fox getDefaultFox() {
        return defaultFox;
    }

    public void setFoxList(List<Fox> foxList) {
        this.foxList = foxList;
    }

    public List<Fox> getFoxList() {
        return this.foxList;
    }
}
