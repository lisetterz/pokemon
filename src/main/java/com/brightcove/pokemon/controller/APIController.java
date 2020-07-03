package com.brightcove.pokemon.controller;

import com.brightcove.pokemon.components.APIComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @Autowired
    APIComponent component;
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @GetMapping("/{id}")
    public int getId(@PathVariable int id){
        return id;
    }
    @GetMapping("pokemon/{name}")
    public String getPokemon(@PathVariable String name){
        return component.getPokemon(name);
    }
    @GetMapping("type/{name}")
    public String getType(@PathVariable String name){
        return component.getType(name);
    }
    @GetMapping("doubleDamage/{pokemon1}-{pokemon2}")
    public String getDoubleDamage(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.doubleDamage(pokemon1,pokemon2);
    }
    @GetMapping("halfOrNoDamage/{pokemon1}-{pokemon2}")
    public String getHalfOrNoDamage(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.halfOrNoDamage(pokemon1,pokemon2);
    }

}
