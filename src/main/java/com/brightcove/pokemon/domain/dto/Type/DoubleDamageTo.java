package com.brightcove.pokemon.domain.dto.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoubleDamageTo{
        private String name;
        private String url;
}
