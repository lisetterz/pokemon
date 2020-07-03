package com.brightcove.pokemon.domain.dto.pokemon;
import com.brightcove.pokemon.domain.dto.pokemon.moves.Moves;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private int base_experience;
    private List<Types> types;
    private List<Moves> moves;
}
