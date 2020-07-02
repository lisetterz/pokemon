package com.brightcove.pokemon.services;

import com.brightcove.pokemon.domain.dto.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class APIServiceImplTest {

    @Autowired
    APIService apiService;
    @BeforeEach
    void setUp() {
    }
    @Test
    public void testGetPokemon() throws Exception{
        Pokemon pokemon = apiService.getPokemon("ditto");
        assertEquals("ditto", pokemon.getName());
    }
}