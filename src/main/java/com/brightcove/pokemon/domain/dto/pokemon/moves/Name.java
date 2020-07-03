package com.brightcove.pokemon.domain.dto.pokemon.moves;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    private String name;
   // private Language language;

    public Name(){}

    public Name(String name){
        name.toString();
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(name);
    }
}
