package com.example.tsl057.kotlinworkshop.models

data class Pokemon(
        val name: String?,
        val picture: String?,
        val types: List<String>?,
        val weight: Int,
        val height: Int)