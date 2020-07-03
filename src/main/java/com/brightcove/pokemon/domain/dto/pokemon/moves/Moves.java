package com.brightcove.pokemon.domain.dto.pokemon.moves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Moves {
    private Move move;
}
