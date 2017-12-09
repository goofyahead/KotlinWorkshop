package com.example.tsl057.kotlinworkshop.pokemonList

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.tsl057.kotlinworkshop.R
import com.example.tsl057.kotlinworkshop.extensions.md5
import com.example.tsl057.kotlinworkshop.extensions.showMessage
import com.example.tsl057.kotlinworkshop.models.Pokemon
import com.example.tsl057.kotlinworkshop.models.PokemonType
import com.example.tsl057.kotlinworkshop.repositories.NetworkPokemonRepository
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info


class PokemonListActivity : AppCompatActivity(), AnkoLogger {

    private val presenter = PokemonListPresenter(NetworkPokemonRepository())
    private var filterFunction: (Pokemon) -> Boolean = { true }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        presenter.loadPokemons({ onPokemonsReady(it) })
    }

    fun onPokemonsReady(pokemons: List<Pokemon>) {
        pokedexList.layoutManager = LinearLayoutManager(this)
        pokedexList.adapter = PokemonAdapter(pokemons.filter(filterFunction), { onPokemonClicked(it) })
    }

    fun onPokemonClicked(pokemon: Pokemon) {
        this.showMessage("Clicked on ${pokemon.name}")
        info("md5 of this pokemon is ${pokemon.toString().md5()}")
        info(pokemon)
        pokemon.attack(pokemon)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.filter_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        filterFunction = when (item.itemId) {
            R.id.electric -> { pokemon: Pokemon -> pokemon.types?.contains(PokemonType.ELECTRIC) ?: false }

            R.id.fire -> { pokemon: Pokemon -> pokemon.types?.contains(PokemonType.FIRE) ?: false }

            R.id.flying -> { pokemon: Pokemon -> pokemon.types?.contains(PokemonType.FLIYING) ?: false }

            else -> { pokemon: Pokemon -> true }
        }
        presenter.loadPokemons({ onPokemonsReady(it) })
        return true
    }
}
