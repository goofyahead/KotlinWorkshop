package com.example.tsl057.kotlinworkshop

import com.example.tsl057.kotlinworkshop.models.Pokemon

interface PokemonListContract {

    interface Presenter {
        fun loadPokemons(callback : (List<Pokemon>) -> Unit)
    }
}