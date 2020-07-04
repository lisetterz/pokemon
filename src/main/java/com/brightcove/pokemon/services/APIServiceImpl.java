package com.brightcove.pokemon.services;

import com.brightcove.pokemon.config.RestTemplateConfig;
import com.brightcove.pokemon.domain.dto.moves.Move;
import com.brightcove.pokemon.domain.dto.moves.Moves;
import com.brightcove.pokemon.domain.dto.pokemon.Pokemon;
import com.brightcove.pokemon.domain.dto.Type.Type;
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

    @Override
    public Type getType(String name) {
        RestTemplate client = config.createRestTemplate();

        ResponseEntity<Type> response = client.exchange("https://pokeapi.co/api/v2/type/" + name, HttpMethod.GET,config.createHeaders(),Type.class);
        return response.getBody();
    }

    @Override
    public com.brightcove.pokemon.domain.dto.moves.Move getMove(String name) {
        RestTemplate client = config.createRestTemplate();

        ResponseEntity<com.brightcove.pokemon.domain.dto.moves.Move> response = client.exchange("https://pokeapi.co/api/v2/move/" + name, HttpMethod.GET,config.createHeaders(),com.brightcove.pokemon.domain.dto.moves.Move.class);
        return response.getBody();
    }
/*
    @Override
    public com.brightcove.pokemon.domain.dto.moves.Moves getMoves(String name) {
        RestTemplate client = config.createRestTemplate();

        ResponseEntity<Moves> response = client.exchange("https://pokeapi.co/api/v2/move/" + name, HttpMethod.GET,config.createHeaders(),Moves.class);
        return response.getBody();
    }*/
}
