package ru.turing.swapi

/**
 * Интерфейс для реализации навигации между фрагментами.
 */
interface ActivityNavigator {

    fun goToFirstFragment()

    fun goToSecondFragment(string: String)
}