package com.brightcove.pokemon.domain.dto.responses;

import java.util.List;

public class ResponseWrap {
    private List<ResponseDTO> response;

    /**
     * @return the persons
     */
    public List<ResponseDTO> getResponse() {
        return response;
    }

    /**
     * @param response the pokemons to set
     */
    public void setResponse(List<ResponseDTO> response) {
        this.response = response;
    }
}
