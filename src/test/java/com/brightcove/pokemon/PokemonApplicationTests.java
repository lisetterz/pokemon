package com.brightcove.pokemon;

import com.brightcove.pokemon.config.RestTemplateConfig;
import com.brightcove.pokemon.domain.dto.Pokemon;
import com.brightcove.pokemon.services.APIService;
import com.brightcove.pokemon.services.APIServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

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
}
