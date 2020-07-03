package com.brightcove.pokemon.services;

import com.brightcove.pokemon.domain.dto.Pokemon;
import com.brightcove.pokemon.domain.dto.Type;

import java.util.List;

public interface APIService {
    Pokemon getPokemon(String name);
    Type getType(String name);
}
