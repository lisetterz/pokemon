package com.brightcove.pokemon.domain.dto.damageRelations;

import com.brightcove.pokemon.domain.dto.Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoDamageFrom {
    private String name;
    private String url;
    private List<Type> type;

}
