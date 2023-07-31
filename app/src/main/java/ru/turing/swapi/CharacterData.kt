package ru.turing.swapi

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import java.io.Serializable

class CharacterData(CharacterDescription: String, CharacterImage: Drawable?) : Serializable {
    val description = CharacterDescription
    val image = CharacterImage
}