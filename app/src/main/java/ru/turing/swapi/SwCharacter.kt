package ru.turing.swapi

import java.io.Serializable

data class SwCharacter(
    val name: String,
    val description: String,
    val imageUrl: String
): Serializable