package com.example.tsl057.kotlinworkshop.pokemonList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tsl057.kotlinworkshop.R
import com.example.tsl057.kotlinworkshop.models.Pokemon
import com.example.tsl057.kotlinworkshop.repositories.NetworkPokemonRepository

class PokemonListActivity : AppCompatActivity() {

    private val presenter = PokemonListPresenter(NetworkPokemonRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        presenter.loadPokemons({onPokemonsReady(it)})
    }

    fun onPokemonsReady(pokemons: List<Pokemon>) {

    }
}
