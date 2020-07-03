package com.brightcove.pokemon.domain.dto.damageRelations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoubleDamageTo{
        private String name;
        private String url;
}
