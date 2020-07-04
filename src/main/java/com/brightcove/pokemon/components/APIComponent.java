package com.brightcove.pokemon.components;

import com.brightcove.pokemon.domain.dto.moves.Moves;
import com.brightcove.pokemon.domain.dto.responses.ResponseDTO;
import com.brightcove.pokemon.domain.dto.responses.ResponseWrapper;
import com.brightcove.pokemon.domain.dto.Type.Type;
import com.brightcove.pokemon.domain.dto.Type.DoubleDamageTo;
import com.brightcove.pokemon.domain.dto.Type.HalfDamageForm;
import com.brightcove.pokemon.domain.dto.Type.NoDamageFrom;
import com.brightcove.pokemon.domain.dto.pokemon.*;
import com.brightcove.pokemon.services.APIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Wrapper;
import java.util.*;

@Component
public class APIComponent {
    @Autowired
    APIServiceImpl service;

    public String getPokemon(String name){
        return service.getPokemon(name).toString();
    }

    public String getType(String name){
        return service.getType(name).toString();
    }

    public String getMove(String name){ return service.getMove(name).toString();}

    /*//mejor no utilizar

     *//*
    public String getMoves(String pokemonName){

        return service.getPokemon(pokemonName).getMoves().toString();}
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
*/
private Type pokemonToTypeObj(String name){
    Pokemon pokemon = service.getPokemon(name);
    List<Types> types= pokemon.getTypes();
    String type_name = types.get(0).getType().getName();
    Type type = service.getType(type_name);
    return type;
}
    private List<Types> pokemonTypes(String name){
        return service.getPokemon(name).getTypes();
    }

/**/
public String doubleDamage(String name1, String name2){
    Type pokemon1_type = pokemonToTypeObj(name1);
    // Type type2 = pokemonToTypeObj(name2);
    List<Types> pokemon1_types = pokemonTypes(name1);
    List<Types> pokemon2_type = pokemonTypes(name2);
    List<DoubleDamageTo> pokemon1_dblDmgTo = pokemon1_type.getDamage_relations().getDouble_damage_to();
    String pokemon1Type= pokemon1_types.get(0).getType().getName();
    String pokemon2Type = pokemon2_type.get(0).getType().getName();
    for(DoubleDamageTo dmg: pokemon1_dblDmgTo) {
        for(Types dmg2: pokemon2_type) {
            if (dmg.getName().equals(dmg2.getType().getName())) {
                pokemon2Type = dmg2.getType().getName();
                return "yes, pokemon " + name1 + " of type " +
                        pokemon1Type + " deals double damage to pokemon " +
                        name2 + " of type " +
                        pokemon2Type;
            }
        }
    }

    return "No, pokemon "+name1+" of type "+
            pokemon1Type+ " doesn't deals double damage to pokemon "+
            name2+" of type "+
            pokemon2Type;
}

    public String halfOrNoDamage(String name1, String name2){
        Type pokemon1_type = pokemonToTypeObj(name1);
        // Type type2 = pokemonToTypeObj(name2);
        List<Types> pokemon1_types = pokemonTypes(name1);
        List<Types> pokemon2_type = pokemonTypes(name2);
        List<HalfDamageForm> pokemon1_halfDmgFrom = pokemon1_type.getDamage_relations().getHalf_damage_from();
        List<NoDamageFrom> pokemon1_noDmgFrom = pokemon1_type.getDamage_relations().getNo_damage_from();
        String pokemon1Type= pokemon1_types.get(0).getType().getName();
        String pokemon2Type = pokemon2_type.get(0).getType().getName();
        for(HalfDamageForm dmg: pokemon1_halfDmgFrom) {
            for(Types dmg2: pokemon2_type) {
                if (dmg.getName().equals(dmg2.getType().getName())) {
                    pokemon2Type = dmg2.getType().getName();
                    return name1+" receives half damage from "+name2;
                }
            }
        }
        for(NoDamageFrom dmg: pokemon1_noDmgFrom) {
            for(Types dmg2: pokemon2_type) {
                if (dmg.getName().equals(dmg2.getType().getName())) {
                    pokemon2Type = dmg2.getType().getName();
                    return name1+" receives no damage from "+name2;
                }
            }
        }

        return name1+" doesn't receive half or no damage from "+name2;
    }


//returns result wrapped
    public ResponseWrapper pokemonMoves(PokemonWrapper pokemonWrapper) {
        List<Pokemon> pokemons = pokemonWrapper.getPokemons();
        List<List<String>> lists = new LinkedList<>();
        for (Pokemon pokemon : pokemons) {
            List<Moves> movesList = pokemon.getMoves();
            List<String> myList = new LinkedList<>();
            for (Moves moves : movesList) {
                myList.add(movesList.get(0).getMove().getName());
            }
        lists.add(myList);
        }
        //it will return a list of the duplicated moves List<String>
        String message = getSameMoves(lists,null, new ArrayList<>()).toString();
        ResponseWrapper responseWrapper = new ResponseWrapper();
        ResponseDTO response = new ResponseDTO();
        response.setMessage(message);
        List<ResponseDTO> listResponse = new ArrayList<>();
        listResponse.add(response);
        responseWrapper.setResponse(listResponse);
        return responseWrapper;
    }
    /*
    public Wrapper wrapObject(Wrapper wrapper){
    return null;
    }
    /*
*/
    /*
public void comparison(){
   // List<String> list1 = new ArrayList<>();

    LinkedList<List<String>> myList = new LinkedList<>();

    List<String> duplicated = getSameMoves(myList,null, new ArrayList<>());
    System.out.println(duplicated.toString());
}

    private List<String> compareEquals(List<String> lista1, List<String> lista2) {
       List<String> duplicates = new ArrayList<>();
        for(String a: lista1){
            for(String b: lista2){
                if(a.equals(b)){
                    duplicates.add(a);
                }
            }
        }
    return duplicates;
    }
*/
    public List<String> getSameMoves(List<List<String>> lists, List<String> list1 ,List<String> current){
        if(lists.isEmpty()) {
            return current;
        }
        if(lists.size()==1) {
            return current;
        }
        if(list1==null) {
            list1 = lists.get(0);
        }
        List<String> list2 = lists.get(1);
        for(String name: list1) {
            if(list2.contains(name)) {
                if(!current.contains(name)) {
                    current.add(name);
                }
            }

        }

        lists.remove(0);

        return getSameMoves(lists,list2,current);

    }
 /*
    public Object[] compareArrays(Object[] array1, Object[] array2){

        for (int i=0; i<array1.length;i++){
            for(int j=0; j<array2.length;j++){
             //   if((array1.getName())
            }
        }
        return null;
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
//de aqui pa bajo
 *//*
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
//de aqui pa rriba
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
