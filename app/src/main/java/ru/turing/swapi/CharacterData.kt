package ru.turing.swapi

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import java.io.Serializable

class CharacterData(CharacterDescription: String, CharacterImage: Drawable?) : Serializable {
    var description = CharacterDescription
    var image = CharacterImage
}