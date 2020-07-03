package com.brightcove.pokemon.domain.dto.pokemon;

import java.util.List;

public class PokemonWrapper {
    private List<Pokemon> pokemons;

    /**
     * @return the persons
     */
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
     * @param pokemons the pokemons to set
     */
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
