package com.brightcove.pokemon.controller;

import com.brightcove.pokemon.components.APIComponent;
import com.brightcove.pokemon.domain.dto.responses.ResponseWrap;
import com.brightcove.pokemon.domain.dto.pokemon.PokemonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {
    @Autowired
    APIComponent component;
    /*
    /**
     * basic hello world for testing
     *//*
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }*/
  /*  @GetMapping("moves/{moveName}")
    public String getMoves(@PathVariable String moveName){
        return component.getMoves(moveName);
    }*/
    /**
     * @param pokemonName name of the pokemon to search
     * @return the information of the pokemon
     */
    @GetMapping("pokemon/{pokemonName}")
    public String getPokemon(@PathVariable String pokemonName){
        return component.getPokemon(pokemonName);
    }
    /**
     * @param typeName name of the type of pokemon to search
     * @return the information of the type of pokemon
     */
    @GetMapping("type/{typeName}")
    public String getType(@PathVariable String typeName){
        return component.getType(typeName);
    }
    /**
     * @param moveName name of the move to search
     * @return the information of the move
     */
    @GetMapping("move/{moveName}")
    public String getMove(@PathVariable String moveName){
        return component.getMove(moveName);
    }

    /*
    @GetMapping("moves/{pokemonName}")
    public String getMoves(@PathVariable String pokemonName){
        return component.getMoves(pokemonName);
    }
*/
    /**
     * @param pokemon1 name of the pokemon that deals the damage
     * @param pokemon2 name of the pokemon that receives the damage
     * @return validates if the first pokemon inflicts double damage to the second one
     */
    @GetMapping("doubleDamageTo/{pokemon1}-{pokemon2}")
    public String getDoubleDamageTo(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.doubleDamageResponse(pokemon1,pokemon2);
    }
    /**
     * @param pokemon1 name of the pokemon that receives the damage
     * @param pokemon2 name of the pokemon that deals the damage
     * @return validates if the first pokemon receives half or no damage from the second one
     */
    @GetMapping("halfOrNoDamageFrom/{pokemon1}-{pokemon2}")
    public String getHalfOrNoDamageFrom(@PathVariable String pokemon1, @PathVariable String pokemon2){
        return component.halfOrNoDamageResponse(pokemon1,pokemon2);
    }
    /**
     * @param pokemonWrapper wrapper class for json array of pokemons
     * @return the moves that all the pokemons given share
     */
    @PostMapping(value = "/sameMoves", consumes = "application/json", produces = "application/json")
    public ResponseWrap getsameMoves(@RequestBody PokemonWrapper pokemonWrapper) {
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
