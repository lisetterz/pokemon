package com.brightcove.pokemon.domain.dto.pokemon;
import com.brightcove.pokemon.domain.dto.moves.Move;
import com.brightcove.pokemon.domain.dto.moves.Moves;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private int base_experience;
    private List<Types> types;
    //private List<PokemonMove> pokemonMove;
   // private List<Move> move;
    private List<Moves> moves;

    // Jackson librabry for JSON/YAML
    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
