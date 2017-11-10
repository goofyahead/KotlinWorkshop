package com.example.tsl057.kotlinworkshop.models

data class Pokemon(
        val name: String?,
        val picture: String = "https://images-na.ssl-images-amazon.com/images/I/31QUl4LeuNL.jpg",
        val types: List<String>?,
        val weight: Int,
        val height: Int)