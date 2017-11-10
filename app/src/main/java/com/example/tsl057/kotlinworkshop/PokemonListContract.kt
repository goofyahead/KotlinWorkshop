package com.example.tsl057.kotlinworkshop

import com.example.tsl057.kotlinworkshop.models.Pokemon

interface PokemonListContract {

    interface View {
       fun onPokemonsReady(pokemons : List<Pokemon>)
    }

    interface Presenter {
        fun register (view : View)
        fun unregister(view : View)
        fun loadPokemons()
    }
}