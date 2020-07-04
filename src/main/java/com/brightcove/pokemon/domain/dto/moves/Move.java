package com.brightcove.pokemon.domain.dto.moves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Move {
    private String name;
   private List<Names> names;
    @Override
    public String toString() {
        return String.format(name);
    }
}

