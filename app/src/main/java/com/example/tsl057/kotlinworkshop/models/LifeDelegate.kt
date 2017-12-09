package com.example.tsl057.kotlinworkshop.models

import kotlin.reflect.KProperty

class LifeDelegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return 30
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}