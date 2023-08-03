package ru.turing.swapi


interface ActivityNavigator {

    fun goToMainFragment()

    fun goToDataFragment(character: CharacterData)
}