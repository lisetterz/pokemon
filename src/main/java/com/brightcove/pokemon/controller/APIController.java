package com.brightcove.pokemon.controller;

import com.brightcove.pokemon.components.APIComponent;
import com.brightcove.pokemon.domain.dto.ResponseWrapper;
import com.brightcove.pokemon.domain.dto.pokemon.Pokemon;
import com.brightcove.pokemon.domain.dto.pokemon.PokemonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("move/{name}")
    public String getMove(@PathVariable String name){
        return component.getMove(name);
    }
    @GetMapping("moves/{name}")
    public String getMoves(@PathVariable String name){
        return component.getMoves(name);
    }

    @GetMapping("doubleDamage/{pokemon1}-{pokemon2}")
    public String getDoubleDamage(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.doubleDamage(pokemon1,pokemon2);
    }

    @GetMapping("halfOrNoDamage/{pokemon1}-{pokemon2}")
    public String getHalfOrNoDamage(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.halfOrNoDamage(pokemon1,pokemon2);
    }

    @PostMapping(
            value = "/createPokemon", consumes = "application/json", produces = "application/json")
    public ResponseWrapper createPokemon(@RequestBody PokemonWrapper pokemonWrapper) {
        return component.pokemonMoves(pokemonWrapper);
    }
/*
    @PostMapping(
            value = "/pokemonMoves", consumes = "application/json", produces = "application/json")
    public ResponseWrapper getPokemonMoves(@RequestBody Pokemon pokemon) {
        return component.pokemonMoves(pokemon);
    }*/
    /*
    @RequestMapping(value="person", method=RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public List<String> savePerson(@RequestBody PokemonWrapper wrapper) {
        List<String> response = new ArrayList<String>();
        for (Pokemon pokemon: wrapper.getPokemons()){
            pokemonService.save(pokemon);
            response.add("Saved person: " + pokemon.toString());
        }
        return response;
    }

     */
    /*
   @RequestMapping(value = "moves", method = RequestMethod.POST, consumes = "application/json", produces="applicatio/json")
   // @ResponseBody
    public List<Moves> savePokemons(@RequestBody PokemonWrapper wrapper){
       /* for (Pokemon pokemon: wrapper.getPokemons()){
            component.getPokemon(pokemon);
        }
      return component.moves(wrapper);

    }*/


}
