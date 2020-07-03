package com.brightcove.pokemon.services;

import com.brightcove.pokemon.domain.dto.pokemon.moves.Move;
import com.brightcove.pokemon.domain.dto.pokemon.Pokemon;
import com.brightcove.pokemon.domain.dto.Type;

public interface APIService {
    Pokemon getPokemon(String name);
    Type getType(String name);
    Move getMove(String name);
}
