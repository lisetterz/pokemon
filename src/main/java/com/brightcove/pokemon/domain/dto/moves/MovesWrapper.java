package com.brightcove.pokemon.domain.dto.moves;

import java.util.List;

public class MovesWrapper {
    private List<Moves> moves;

    /**
     * @return the pokemons
     */
    public List<Moves> getMoves() {
        return moves;
    }

    /**
     * @param moves the pokemons to set
     */
    public void setPokemons(List<Moves> moves) {
        this.moves = moves;
    }
}
