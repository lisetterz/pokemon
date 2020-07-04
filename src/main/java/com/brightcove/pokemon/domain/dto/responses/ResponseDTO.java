package com.brightcove.pokemon.domain.dto.responses;

import com.brightcove.pokemon.domain.dto.moves.Moves;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class ResponseDTO {
    private String name;
    private String message;
    private List<Moves> moves;
}
