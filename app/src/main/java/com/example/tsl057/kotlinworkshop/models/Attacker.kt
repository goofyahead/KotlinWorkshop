package com.example.tsl057.kotlinworkshop.models

import java.io.Serializable

interface Attacker : Serializable{
    fun attack(pokemon: Pokemon)
}