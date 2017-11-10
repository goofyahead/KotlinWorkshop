package com.example.tsl057.kotlinworkshop

import com.example.tsl057.kotlinworkshop.models.Pokemon

interface PokemonRepository {
    fun getAllPokemons() : List<Pokemon?>
}