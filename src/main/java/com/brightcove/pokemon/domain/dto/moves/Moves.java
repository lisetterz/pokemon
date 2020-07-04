package com.brightcove.pokemon.domain.dto.moves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moves {
    private String name;
  //  private List<Names> names;
    private Move move;
}
