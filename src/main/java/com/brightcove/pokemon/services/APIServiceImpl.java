package com.brightcove.pokemon.services;

import com.brightcove.pokemon.config.RestTemplateConfig;
import com.brightcove.pokemon.domain.dto.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIServiceImpl implements APIService{
    @Autowired
    RestTemplateConfig config;
    @Override
    public Pokemon getPokemon(String name) {
    RestTemplate client = config.createRestTemplate();

      ResponseEntity<Pokemon> response = client.exchange("https://pokeapi.co/api/v2/pokemon/" + name, HttpMethod.GET,config.createHeaders(),Pokemon.class);
        return response.getBody();

    }
}
