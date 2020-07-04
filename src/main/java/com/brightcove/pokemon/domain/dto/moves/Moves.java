package com.brightcove.pokemon.domain.dto.moves;

import com.brightcove.pokemon.domain.dto.pokemon.PokemonMove;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moves {
  //  private List<Names> names;
    private Move move;
  //  private List<PokemonMove> pokemonMove;
}
