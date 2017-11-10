package com.example.tsl057.kotlinworkshop.pokemonList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tsl057.kotlinworkshop.R
import com.example.tsl057.kotlinworkshop.models.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter(private val pokemonList: List<Pokemon>,
                     private val itemClick: (Pokemon) -> Unit)
    : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPokemon(pokemonList[position])
    }

    class ViewHolder(view: View, private val itemClick: (Pokemon) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindPokemon(pokemon: Pokemon) {
            with(pokemon) {
                Picasso.with(itemView.context)
                        .load(picture)
                        .into(itemView.pokemonImage)
                itemView.pokemonName.text = name ?: "unknown"
                itemView.pokemonWeight.text = weight.toString()
                itemView.pokemonHeight.text = height.toString()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}