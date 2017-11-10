package com.example.tsl057.kotlinworkshop.repositories

import com.example.tsl057.kotlinworkshop.PokemonRepository
import com.example.tsl057.kotlinworkshop.models.Pokemon

class NetworkPokemonRepository : PokemonRepository {

    override fun getAllPokemons(): List<Pokemon?> {
        val bulbasur = Pokemon(
                "bulbasur",
                "https://cdn.bulbagarden.net/upload/thumb/2/21/001Bulbasaur.png/250px-001Bulbasaur.png",
                listOf("grass", "poison") ,
                12,
                12)
        val pikachu = Pokemon(
                "pikachu",
                "https://cdn.bulbagarden.net/upload/thumb/0/0d/025Pikachu.png/250px-025Pikachu.png",
                listOf("electric") ,
                4,
                20)
        val charmander = Pokemon(
                "charmander",
                "https://cdn.bulbagarden.net/upload/thumb/7/73/004Charmander.png/250px-004Charmander.png",
                listOf("fire", "flying") ,
                2,
                32)
        val unknownPokemon = Pokemon(
                name = null,
                types = null,
                weight = 10,
                height = 22)
        val charizard = Pokemon(
                "charizard",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
                listOf("fire") ,
                12,
                40)
        val pidgeoto = Pokemon(
                "pidgeotto",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png",
                listOf("flying") ,
                3,
                2)

        return listOf(bulbasur, pikachu, charmander, unknownPokemon, null, charizard, pidgeoto)
    }
}