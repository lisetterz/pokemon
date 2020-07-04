package com.brightcove.pokemon.domain.dto.responses;

import com.brightcove.pokemon.domain.dto.pokemon.Pokemon;
import lombok.Data;

@Data
public class PokemonRequestDTO {
    private Pokemon pokemon;
}
