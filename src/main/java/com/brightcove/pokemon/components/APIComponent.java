package com.brightcove.pokemon.components;

import com.brightcove.pokemon.domain.dto.ResponseDTO;
import com.brightcove.pokemon.domain.dto.ResponseWrapper;
import com.brightcove.pokemon.domain.dto.pokemon.*;
import com.brightcove.pokemon.domain.dto.pokemon.moves.Moves;
import com.brightcove.pokemon.services.APIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class APIComponent {
    @Autowired
    APIServiceImpl service;
/*
    public String dealDoubleDamage(String pokemon1, String pokemon2){
        Type type1 =service.getType(pokemon1);
        Type type2 =service.getType(pokemon2);
        DoubleDamageTo[] doubleDamageTo = type1.getDamage_relations().getDouble_damage_to();
        for(DoubleDamageTo current: doubleDamageTo ){
            if(current.getName().equals(type1.getName())){
                return "yes";
            }
        }
        return "no";
    }
*/
    public String getPokemon(String name){
        return service.getPokemon(name).toString();
    }

    public String getType(String name){
        return service.getType(name).toString();
    }

    public String getMove(String name){ return service.getMove(name).toString();}
/*
    private Type pokemonToTypeObj(String name){
        Pokemon pokemon = service.getPokemon(name);
        Types[] types= pokemon.getTypes();
        String type_name = types[0].getType().getName();
        Type type = service.getType(type_name);
        return type;
    }
    private Types[] pokemonTypes(String name){
        return service.getPokemon(name).getTypes();
    }
/*
    public String doubleDamage(String name1, String name2){

        Type pokemon1_type = pokemonToTypeObj(name1);
       // Type type2 = pokemonToTypeObj(name2);
        Types[] pokemon1_types = pokemonTypes(name1);
        Types[] pokemon2_type = pokemonTypes(name2);
       DoubleDamageTo[] pokemon1_dblDmgTo = pokemon1_type.getDamage_relations().getDouble_damage_to();
       String pokemon1Type= pokemon1_types[0].getType().getName();
        String pokemon2Type = pokemon2_type[0].getType().getName();

       for(int i = 0; i<pokemon1_dblDmgTo.length;i++) {
           for(int j=0; j<pokemon2_type.length;j++){
               System.out.println("yes, "+pokemon1Type+ " deals double damage to "+ pokemon2Type);

               if (pokemon1_dblDmgTo[i].getName().equals(pokemon2_type[j].getType().getName())) {

                  pokemon2Type = pokemon2_type[j].getType().getName();
                   return "yes, pokemon "+name1+" of type "+
                           pokemon1Type+ " deals double damage to pokemon "+
                           name2+" of type "+
                           pokemon2Type;

               }
           }

       }
          return "No, pokemon "+name1+" of type "+
                pokemon1Type+ " doesn't deals double damage to pokemon "+
                name2+" of type "+
                pokemon2Type;
    }

    public Object[] compareArrays(Object[] array1, Object[] array2){

        for (int i=0; i<array1.length;i++){
            for(int j=0; j<array2.length;j++){
             //   if((array1.getName())
            }
        }
        return null;
    }
    /*
    public String halfOrNoDamage(String name1, String name2){
    //   String positive =name1+" receives half or no damage from "+name2;
     //  String negative = name1+" doesn't receive half or no damage from "+name2;
        Type pokemon1_type = pokemonToTypeObj(name1);

        Types[] pokemon2_type = pokemonTypes(name2);
        HalfDamageForm[] pokemon1_halfDmgFrom = pokemon1_type.getDamage_relations().getHalf_damage_from();
        NoDamageFrom[] pokemon1_noDmgFrom = pokemon1_type.getDamage_relations().getNo_damage_from();
        for(int i = 0; i<pokemon1_halfDmgFrom.length;i++) {
            for(int j=0; j<pokemon2_type.length;j++){
                //   System.out.println("yes, "+pokemon1Type+ " deals double damage to "+ pokemon2Type);

                if (pokemon1_halfDmgFrom[i].getName().equals(pokemon2_type[j].getType().getName())) {

                    return name1+" receives half damage from "+name2;
                }
            }

        }
        for(int i = 0; i<pokemon1_noDmgFrom.length;i++) {
            for(int j=0; j<pokemon2_type.length;j++){
                //   System.out.println("yes, "+pokemon1Type+ " deals double damage to "+ pokemon2Type);

                if (pokemon1_noDmgFrom[i].getName().equals(pokemon2_type[j].getType().getName())) {

                    return name1+" receives no damage from "+name2;
                }
            }

        }
        return name1+" doesn't receive half or no damage from "+name2;
    }
/*
public String sameMoves(String[] pokemons){
        Pokemon pokemon;
        Moves[] moves;
  //  HashMap<Moves> sameMoves = new HashMap<>();
        for(int i=0; i<pokemons.length;i++){
            pokemon = service.getPokemon(pokemons[i]);
            moves = pokemon.getMoves();
            for(int j = i ;i<moves.length;j++){

            }
        }
return "";
}
*/
/*
    public String sameMoves(String[] pokemons) {
          int size = pokemons.length;
          String [][] matrix= new String[size][];
         // HashMap<Pokemon,Hashtable<Moves, Move>> hm = new HashMap<>();
          HashMap<Pokemon, Moves[]> myMoves = new HashMap<>();
        for(int i=0; i<size;i++){
           Pokemon pokemon = service.getPokemon(pokemons[i]);
           Moves[] moves = pokemon.getMoves();
           for(int j=0; j<moves.length;j++){
               myMoves.put(pokemon,moves);
           }
        }

        return myMoves.toString();
    }

 */
public List<Moves> moves(PokemonWrapper pokemonWrapper){
    List<Pokemon> pokemons = pokemonWrapper.getPokemons();
   Pokemon poke = pokemons.get(0);
  // List<Moves> moves = poke.getMoves();
    return poke.getMoves();
}
public ResponseDTO addPokemon(Pokemon pokemon){
    ResponseDTO response = new ResponseDTO();
    response.setName(pokemon.getName());
    response.setMessage("saved");
    return response;
}
public void getMoves(){

}
public ResponseWrapper pokemonMoves(PokemonWrapper pokemonWrapper) {
   ResponseWrapper wrapper = new ResponseWrapper();
    List<ResponseDTO> list = new ArrayList<>();
   List<Pokemon> pokemonList = new ArrayList<>();
   for(Pokemon pokemon : pokemonWrapper.getPokemons()){
       pokemonList.add(pokemon);

       ResponseDTO response = addPokemon(pokemon);
       list.add(response);
   }

   wrapper.setResponse(list);
    return wrapper;
}
/*
    public ResponseWrapper pokemonMoves(Pokemon pokemon) {
        ResponseWrapper wrapper = new ResponseWrapper();
        List<MovesResponse> list = new ArrayList<>();
            MovesResponse response = addPokemon(pokemon);
            response.setName(pokemon.getName());
            response.setMoves(pokemon.getMoves());
            list.add(response);
        wrapper.setResponse(list);
        return wrapper;
    }
*/
/*public ResponseWrapper savePokemon (Pokemon pokemon) {
   ResponseWrapper wrapper = new ResponseWrapper();
   MovesResponse response = new MovesResponse();
   response.setName(pokemon.getName());
   response.setMessage("saved");
   List<MovesResponse> list = new ArrayList<>();
    list.add(response);
   wrapper.setResponse(list);
   response.setName("charmander");
   list.add(response);
    return wrapper;
}*/
}
