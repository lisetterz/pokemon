package com.brightcove.pokemon.domain.dto.pokemon.moves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Names {
    private List<Name> name;

}
