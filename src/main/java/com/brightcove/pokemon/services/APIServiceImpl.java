package com.brightcove.pokemon.services;

import com.brightcove.pokemon.domain.dto.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class APIServiceImpl implements APIService{
    private RestTemplate restTemplate;

    public APIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Pokemon getPokemon(String name) {
        Pokemon pokemon =restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name,Pokemon.class);
        return pokemon;
    }
}
