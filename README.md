# pokemon

POKEMON REST API

## Getting Started

This API will consume data from the API https://pokeapi.co/ and will make comparisons to determine the advantages and characteristics of the pokemons.

### Prerequisites

```
Java v8.1+
Postman*
```
### Installing
1.
run jar pokemon-0.0.1-SNAPSHOT.jar
java -jar build/libs/pokemon-0.0.1-SNAPSHOT.jar


End with an example of getting some data out of the system or using it for a little demo

## Running the tests
Tests will run on the startup of the application.

### Break down into end to end tests
```
pokemonTest, getTypeTest
will confirm the correcta data (name) is retreive from API https://pokeapi.co/

dealDoubleDamage, getHalfOrNoDamage 
will compare the damage between pokemons based on their types:



```
### And coding style tests

void dealDoubleDamageTo(){
		assertTrue(component.doubleDamage("starmie","charmander"));
		assertFalse(component.doubleDamage("charmander","starmie"));
	}

```
will prove that starmie deals double damage to charmander and charmander doesn[t deal double damage to starmie
```
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
```
Bulbasaur receives half damage from starmie
Starmie doesn't receives half damage from bulbasaur
Meowth receives no damage from gengar.
Charmander doesn't receive no damage from starmie
```

## Built With

* [Spring](https://spring.io) - The web framework used
* [Gradle](https://gradle.org) - Dependency Management
* [JUnit](http://junit.sourceforge.net) -Test


## Versioning
 For the versions available, see the [tags on this repository](https://github.com/lisetterz/pokemon/releases/tags). 

## Authors

* **Lisette Ramirez** - *Initial work* - [PurpleBooth](ttps://github.com/lisetterz)


## Acknowledgments

* Inspiration
* etc

