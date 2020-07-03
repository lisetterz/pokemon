package com.brightcove.pokemon.domain.dto.pokemon.moves;

import java.util.List;

public class MovesWrapper {
    private List<Moves> moves;

    /**
     * @return the persons
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
