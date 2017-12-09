package com.example.tsl057.kotlinworkshop.models

import java.io.Serializable

enum class PokemonType { GRASS, POISON, FIRE, ELECTRIC, FLIYING }

data class Pokemon(
        val name: String?,
        val picture: String = "https://images-na.ssl-images-amazon.com/images/I/31QUl4LeuNL.jpg",
        val types: List<PokemonType>?,
        val weight: Int,
        val height: Int,
        val attack: Attacker = BasicAttack()) : Attacker by attack, Serializable {

    var lifePoints by LifeDelegate()

    init {
        lifePoints = 30
    }
}

