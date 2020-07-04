package com.brightcove.pokemon.domain.dto.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DamageRelations {
    private List<DoubleDamageTo> double_damage_to;
    private List<HalfDamageForm> half_damage_from;
    private List<NoDamageFrom> no_damage_from;

}
