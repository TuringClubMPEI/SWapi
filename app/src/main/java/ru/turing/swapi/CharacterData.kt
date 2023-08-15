package ru.turing.swapi

import android.graphics.drawable.Drawable
import java.io.Serializable

data class CharacterData(
    val name: String,
    val description: String,
    val image: Drawable?
) : Serializable