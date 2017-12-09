package com.example.tsl057.kotlinworkshop.models

import com.example.tsl057.kotlinworkshop.models.PokemonType.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class ElectricAttack : Atacker, AnkoLogger {
    private var damage: Int = 10

    override fun attack(pokemon: Pokemon) {
        pokemon.types?.map {
            damage = when (it) {
                FIRE -> {
                    info("its supper effective")
                    30
                }
                POISON -> {
                    info("its supper effective")
                    20
                }
                else -> {
                    info("not very effective")
                    10
                }
            }
        }
        pokemon.lifePoints = pokemon.lifePoints - damage
    }
}