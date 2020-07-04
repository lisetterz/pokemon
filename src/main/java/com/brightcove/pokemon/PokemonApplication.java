package com.brightcove.pokemon;

import com.brightcove.pokemon.services.APIServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PokemonApplication {


	private static final Logger log = LoggerFactory.getLogger(PokemonApplication.class);

	APIServiceImpl apiServiceImp;


	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

}
