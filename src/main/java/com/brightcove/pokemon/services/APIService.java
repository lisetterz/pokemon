package com.brightcove.pokemon.services;

import com.brightcove.pokemon.domain.dto.Pokemon;

import java.util.List;

public interface APIService {
    Pokemon getPokemon(String name);
}
