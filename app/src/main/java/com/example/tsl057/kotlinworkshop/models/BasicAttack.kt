package com.example.tsl057.kotlinworkshop.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class BasicAttack : Attacker, AnkoLogger {
    override fun attack(pokemon: Pokemon) {
        pokemon.lifePoints -= 10
        info("well kinda basic attack")
    }
}