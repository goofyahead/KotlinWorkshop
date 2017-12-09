package com.example.tsl057.kotlinworkshop.models

import java.io.Serializable
import kotlin.reflect.KProperty

class LifeDelegate : Serializable {

    operator fun getValue(pokemon: Pokemon, property: KProperty<*>): Int {
        return 20
    }

    operator fun setValue(pokemon: Pokemon, property: KProperty<*>, value: Int) {
        println("$value has been assigned to '${property.name} in ${pokemon.name}.'")
    }
}