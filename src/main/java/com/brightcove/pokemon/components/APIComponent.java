package com.brightcove.pokemon.components;

import com.brightcove.pokemon.domain.dto.moves.Move;
import com.brightcove.pokemon.domain.dto.moves.Moves;
import com.brightcove.pokemon.domain.dto.moves.Name;
import com.brightcove.pokemon.domain.dto.moves.Names;
import com.brightcove.pokemon.domain.dto.responses.ResponseDTO;
import com.brightcove.pokemon.domain.dto.responses.ResponseWrap;
import com.brightcove.pokemon.domain.dto.Type.Type;
import com.brightcove.pokemon.domain.dto.Type.DoubleDamageTo;
import com.brightcove.pokemon.domain.dto.Type.HalfDamageForm;
import com.brightcove.pokemon.domain.dto.Type.NoDamageFrom;
import com.brightcove.pokemon.domain.dto.pokemon.*;
import com.brightcove.pokemon.services.APIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

   /* public String getMoves(String name){ return service.getMoves(name).toString();}
*/
   /*
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

public Boolean doubleDamage(String name1, String name2){
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
                return true;
            }
        }
    }

    return false;
}
public String doubleDamageStr(boolean flag, String pokemon1Name, String pokemon2Name){
    if(flag==true){
                return "yes, pokemon " + pokemon1Name + " deals double damage to pokemon " +
                        pokemon2Name ;

    }else  return "No, pokemon "+pokemon1Name+" doesn't deals double damage to pokemon "+ pokemon2Name;
}
public String doubleDamageResponse(String name1, String name2){
    boolean flag = doubleDamage(name1,name2);
    String message =doubleDamageStr(flag, name1, name2);
    return message;

}

public String halfOrNoDamageResponse(String name1, String name2){
        boolean flag = halfOrNoDamage(name1,name2);
        String message =doubleDamageStr(flag, name1, name2);
        return message;

    }
    public String halfOrNoDamageStr(boolean flag, String pokemon1Name, String pokemon2Name){
        if(flag==true){
            return pokemon1Name+" receives half damage from "+pokemon2Name ;

        }
        return pokemon1Name+" doesn't receive half or no damage from "+pokemon2Name;
    }


    public Boolean halfOrNoDamage(String name1, String name2){
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
                    return true;
                }
            }
        }
        for(NoDamageFrom dmg: pokemon1_noDmgFrom) {
            for(Types dmg2: pokemon2_type) {
                if (dmg.getName().equals(dmg2.getType().getName())) {
                    pokemon2Type = dmg2.getType().getName();
                    return true;
                }
            }
        }

        return false;
    }


//returns result wrapped
    public Move getMoveObj(String name){
        Move move= service.getMove(name);
        return move;
    }
    public String moveLanguage(List<String> message){
    List<Move> moveList = new ArrayList<>();
    List<List<Names>> namesList = new ArrayList<>();
        List<Names> namesList2 = new ArrayList<>();
        List<Name> nameList = new ArrayList<>();
        for(String move: message){
            moveList.add(getMoveObj(move));
        }
        for(Move a: moveList){
            namesList.add(a.getNames());

;        }
        int count =0;
        for(List<Names> n :namesList){
            if(n.get(count).getLanguage().equals("es")){
                nameList.add(n.get(count).getName());
            }
        }
    return nameList.toString();
    }
    //este es el bueno
public Pokemon getPokemonObj(String name){
    Pokemon pokemon= service.getPokemon(name);
    return pokemon;
}
    public ResponseWrap pokemonMoves(PokemonWrapper pokemonWrapper) {
        List<Pokemon> pokemons = pokemonWrapper.getPokemons();
        List<List<String>> lists = new LinkedList<>();
        for (Pokemon pokeWrapp : pokemons) {
            Pokemon pokemon = getPokemonObj(pokeWrapp.getName());
            List<Moves> movesList = pokemon.getMoves();
            List<String> myList = new LinkedList<>();
            int count=0;
            for (Moves moves : movesList) {
                myList.add(movesList.get(count).getMove().getName());
                count++;
            }
        lists.add(myList);
        }
        //it will return a list of the duplicated moves List<String>
        List<String> message = getSameMoves(lists,null, new ArrayList<>());
       // String messageStr = moveLanguage(message);
        String messageStr =message.toString();

       //wrap response
        ResponseWrap responseWrap = new ResponseWrap();
        ResponseDTO response = new ResponseDTO();
        response.setMessage(messageStr);
        List<ResponseDTO> listResponse = new ArrayList<>();
        listResponse.add(response);
        responseWrap.setResponse(listResponse);
        return responseWrap;
    }
    public String callMoves(List<String> list){

        return "";
    }
    //aqui termina el bueno*/
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


//de aqui pa bajo
 /*
public List<Moves> moves(PokemonWrapper pokemonWrapper){
    List<Pokemon> pokemons = pokemonWrapper.getPokemons();
   Pokemon poke = pokemons.get(0);
  // List<Moves> moves = poke.getMoves();
    return poke.getMoves();
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
