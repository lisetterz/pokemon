package com.brightcove.pokemon;

import com.brightcove.pokemon.domain.dto.Pokemon;
import com.brightcove.pokemon.domain.dto.Type;
import com.brightcove.pokemon.services.APIService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokemonApplicationTests {
	@Autowired
	APIService apiService;
	@Test
	void contextLoads() {
	}

	@Test
	void getPokemonTest(){
		Pokemon pokemon = apiService.getPokemon("ditto");
		System.out.println(pokemon.getName());
	}

	@Test
	void getTypeTest(){
		Type type =apiService.getType("ground");
		System.out.println(type.getName());
	}
/*
	@Test
	void getPokimonTest(){
		Pokemon pokemon = servicio.getPokemon("ditto");
	}*/
}
