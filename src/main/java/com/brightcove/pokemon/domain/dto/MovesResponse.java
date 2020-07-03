package com.brightcove.pokemon.domain.dto;

import com.brightcove.pokemon.domain.dto.pokemon.Moves;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class MovesResponse {
    private String name;
    private String message;
   // private Moves moves;
}
