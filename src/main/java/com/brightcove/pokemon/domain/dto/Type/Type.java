package com.brightcove.pokemon.domain.dto.Type;

import com.brightcove.pokemon.domain.dto.moves.Moves;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
   private int id;
   private String name;
    private DamageRelations damage_relations;
   private List<Moves> moves;

}
