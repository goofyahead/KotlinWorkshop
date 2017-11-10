package com.example.tsl057.kotlinworkshop.pokemonList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.tsl057.kotlinworkshop.R
import com.example.tsl057.kotlinworkshop.extensions.md5
import com.example.tsl057.kotlinworkshop.extensions.showMessage
import com.example.tsl057.kotlinworkshop.models.Pokemon
import com.example.tsl057.kotlinworkshop.repositories.NetworkPokemonRepository
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class PokemonListActivity : AppCompatActivity(), AnkoLogger {

    private val presenter = PokemonListPresenter(NetworkPokemonRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        presenter.loadPokemons({onPokemonsReady(it)})
    }

    fun onPokemonsReady(pokemons: List<Pokemon>) {
        pokedexList.layoutManager = LinearLayoutManager(this)
        pokedexList.adapter = PokemonAdapter(pokemons,{onPokemonClicked(it)})
    }

    fun onPokemonClicked(pokemon: Pokemon){
        this.showMessage("Clicked on ${pokemon.name}")
        info("md5 of this pokemon is ${pokemon.toString().md5()}")
    }
}
