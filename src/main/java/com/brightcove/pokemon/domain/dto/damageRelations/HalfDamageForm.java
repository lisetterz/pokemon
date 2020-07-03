package com.brightcove.pokemon.domain.dto.damageRelations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HalfDamageForm {
    private String name;
    private String url;

}
