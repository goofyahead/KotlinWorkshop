package com.example.tsl057.kotlinworkshop.pokemonList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tsl057.kotlinworkshop.PokemonListContract
import com.example.tsl057.kotlinworkshop.R
import com.example.tsl057.kotlinworkshop.models.Pokemon

class PokemonListActivity : AppCompatActivity(), PokemonListContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
    }

    override fun onPokemonsReady(pokemons: List<Pokemon>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
