package com.brightcove.pokemon.domain.dto.damageRelations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DamageRelations {
    private DoubleDamageTo[] double_damage_to;
    private HalfDamageForm[] half_damage_from;
    private NoDamageFrom[] no_damage_from;

}
