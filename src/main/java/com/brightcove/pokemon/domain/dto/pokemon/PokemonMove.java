package com.brightcove.pokemon.domain.dto.pokemon;

import com.brightcove.pokemon.domain.dto.moves.Move;
import com.brightcove.pokemon.domain.dto.moves.Names;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonMove {
    private String name;
    //private List<Names> names;
}
