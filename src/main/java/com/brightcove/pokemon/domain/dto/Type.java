package com.brightcove.pokemon.domain.dto;

import com.brightcove.pokemon.domain.dto.damageRelations.DamageRelations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Type {
   private int id;
   private String name;
    private DamageRelations damage_relations;
   // private String url;

}
