package com.brightcove.pokemon;

import com.brightcove.pokemon.services.APIServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PokemonApplication {


	private static final Logger log = LoggerFactory.getLogger(PokemonApplication.class);

	APIServiceImpl apiServiceImp;


	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}


	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

}
