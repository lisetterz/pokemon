package com.brightcove.pokemon;

import com.brightcove.pokemon.components.APIComponent;
import com.brightcove.pokemon.domain.dto.pokemon.Pokemon;
import com.brightcove.pokemon.domain.dto.Type.Type;
import com.brightcove.pokemon.domain.dto.pokemon.PokemonWrapper;
import com.brightcove.pokemon.domain.dto.responses.ResponseWrap;
import com.brightcove.pokemon.services.APIService;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
class PokemonApplicationTests {
	@Autowired
	APIService apiService;
	APIComponent component;
	@Test
	void contextLoads() {
	}

	@Test
	void getPokemonTest(){
		Pokemon pokemon = apiService.getPokemon("ditto");
		assertEquals("ditto", pokemon.getName());
		System.out.println(pokemon.getName());

	}

	@Test
	void getTypeTest(){
		Type type =apiService.getType("ground");
		assertEquals("ground", type.getName());
		System.out.println(type.getName());

	}
	@Test
	void dealDoubleDamageTo(){
		assertTrue(component.doubleDamage("starmie","charmander"));
		assertFalse(component.doubleDamage("charmander","starmie"));
	}
	@Test
	void getHalfOrNoDamage(){
		//halfdamage true
		assertTrue(component.doubleDamage("bulbasaur","starmie"));
		//halfDamage false
		assertFalse(component.doubleDamage(" starmie ","bulbasaur"));
		//noDamage true
		assertTrue(component.doubleDamage(" meowth ","gengar"));
		//no damage false
		assertFalse(component.doubleDamage(" charmander ","starmie"));
	}
	@Test
	void getSameMoves(){
		PokemonWrapper pokemowrapper = new PokemonWrapper();
		Pokemon pokemon = new Pokemon();
		Pokemon pokemon2 = new Pokemon();
		Pokemon pokemon3 = new Pokemon();
		pokemon.setName("pikachu");
		pokemon2.setName("meowth");
		pokemon3.setName("bulbasaur");
		List<Pokemon> list = new ArrayList<>();
		list.add(pokemon);
		list.add(pokemon2);
		list.add(pokemon3);
		pokemowrapper.setPokemons(list);
		ResponseWrap response = component.pokemonMoves(pokemowrapper);
		System.out.println(response.getResponse().toString());
	}
}
