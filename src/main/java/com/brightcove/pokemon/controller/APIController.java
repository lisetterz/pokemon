package com.brightcove.pokemon.controller;

import com.brightcove.pokemon.components.APIComponent;
import com.brightcove.pokemon.domain.dto.responses.ResponseWrapper;
import com.brightcove.pokemon.domain.dto.pokemon.PokemonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {
    @Autowired
    APIComponent component;
//Methods not for common user
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @GetMapping("pokemon/{pokemonName}")
    public String getPokemon(@PathVariable String pokemonName){
        return component.getPokemon(pokemonName);
    }
    @GetMapping("type/{typeName}")
    public String getType(@PathVariable String typeName){
        return component.getType(typeName);
    }
    @GetMapping("move/{moveName}")
    public String getMove(@PathVariable String moveName){
        return component.getMove(moveName);
    }
   //mejor no utilizarlo
    /*
    @GetMapping("moves/{pokemonName}")
    public String getMoves(@PathVariable String pokemonName){
        return component.getMoves(pokemonName);
    }
*/
    @GetMapping("doubleDamage/{pokemon1}-{pokemon2}")
    public String getDoubleDamage(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.doubleDamage(pokemon1,pokemon2);
    }

    @GetMapping("halfOrNoDamage/{pokemon1}-{pokemon2}")
    public String getHalfOrNoDamage(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.halfOrNoDamage(pokemon1,pokemon2);
    }

    @PostMapping(value = "/pokemonMoves", consumes = "application/json", produces = "application/json")
    public ResponseWrapper getPokemonMoves(@RequestBody PokemonWrapper pokemonWrapper) {
        return component.pokemonMoves(pokemonWrapper);
    }
/*
    @PostMapping(
            value = "/pokemonMoves", consumes = "application/json", produces = "application/json")
    public ResponseWrapper getPokemonMoves(@RequestBody Pokemon pokemon) {
        return component.pokemonMoves(pokemon);
    }
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
