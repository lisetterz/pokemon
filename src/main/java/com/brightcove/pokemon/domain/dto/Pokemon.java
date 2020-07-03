package com.brightcove.pokemon.domain.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private int base_experience;
    private Types[] types;
}
