package com.brightcove.pokemon.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Types {
    private int slot;
    private Type type;
   @Data
    public class Type{
        private String name;
        private String url;
    }
}
