package com.brightcove.pokemon.domain.dto;

import com.brightcove.pokemon.domain.dto.pokemon.Moves;

import java.util.List;

public class ResponseWrapper {
    private List<MovesResponse> response;

    /**
     * @return the persons
     */
    public List<MovesResponse> getResponse() {
        return response;
    }

    /**
     * @param response the pokemons to set
     */
    public void setResponse(List<MovesResponse> response) {
        this.response = response;
    }
}
