package com.brightcove.pokemon.domain.dto.moves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Names {
    private Name name;
    private Language language;

}
