package com.example.tsl057.kotlinworkshop.PokemonBattle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.example.tsl057.kotlinworkshop.R
import com.example.tsl057.kotlinworkshop.extensions.showMessage
import com.example.tsl057.kotlinworkshop.models.Pokemon
import com.example.tsl057.kotlinworkshop.models.PokemonType
import com.example.tsl057.kotlinworkshop.pokemonList.PokemonListActivity
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_pokemon_battle.*
import kotlinx.android.synthetic.main.content_pokemon_battle.*

class PokemonBattle : AppCompatActivity() {

    private var rattata : Pokemon = Pokemon(
            "rattata",
            "",
            listOf(PokemonType.GRASS),
            5,
            32)

    private var selectedPokemon: Pokemon? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_battle)
        setSupportActionBar(toolbar)

        pokemonHealth.max = rattata.lifePoints

        selectPokemon.setOnClickListener { view ->
            var selectPokemonIntent = Intent(this, PokemonListActivity::class.java)
            startActivityForResult(selectPokemonIntent, 1)
        }

        currentPokemon.setOnClickListener { view ->
            selectedPokemon?.attack(rattata)
            showMessage("attacked!")
            updateLife()
        }

    }

    private fun updateLife() {
        pokemonHealth.progress = rattata.lifePoints
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            selectedPokemon = data?.getSerializableExtra("POKEMON") as Pokemon
            Picasso.with(this)
                    .load(selectedPokemon?.picture)
                    .into(currentPokemon)
        }
    }
}
