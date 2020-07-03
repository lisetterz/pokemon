package com.brightcove.pokemon.components;

import com.brightcove.pokemon.domain.dto.Pokemon;
import com.brightcove.pokemon.domain.dto.Type;
import com.brightcove.pokemon.domain.dto.Types;
import com.brightcove.pokemon.domain.dto.damageRelations.DoubleDamageTo;
import com.brightcove.pokemon.services.APIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public Type pokemonToTypeObj(String name){
        Pokemon pokemon = service.getPokemon(name);
        Types[] types= pokemon.getTypes();
        String type_name = types[0].getType().getName();
        Type type = service.getType(type_name);
        return type;
    }
    public Types[] pokemonTypes(String name){
        return service.getPokemon(name).getTypes();
    }

    public String doubleDamage(String name1, String name2){

        Type pokemon1_type = pokemonToTypeObj(name1);
      //  Type type2 = pokemonToTypeObj(name2);
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


}
