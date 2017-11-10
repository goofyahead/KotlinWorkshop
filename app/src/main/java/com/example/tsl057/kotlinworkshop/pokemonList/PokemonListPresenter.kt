package com.example.tsl057.kotlinworkshop.pokemonList

import com.example.tsl057.kotlinworkshop.PokemonListContract
import com.example.tsl057.kotlinworkshop.PokemonRepository
import com.example.tsl057.kotlinworkshop.models.Pokemon

class PokemonListPresenter(
        private val pokemonRepository: PokemonRepository)
    : PokemonListContract.Presenter {

    override fun loadPokemons(callback: (List<Pokemon>) -> Unit) {
        callback(pokemonRepository.getAllPokemons())
    }
}