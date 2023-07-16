package ru.turing.swapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.turing.swapi.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    /**
     * Не делаем инициализацию с помощью by lazy так как для инициализации биндинга в фрагменте
     * необходимы parent и inflater которые передаются в качестве аргументов в onCreateView
     */
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.buttonFirstFragment.setOnClickListener {
            /**
             * проверяем является ли activity к которой прикреплен фрагмент реализующей интерфейс
             * ActivityNavigator
             */
            if (activity is ActivityNavigator) {
                //если да, то вызываем метод интерфейса
                (activity as ActivityNavigator).goToSecondFragment(binding.editText.text.toString())
            }
        }

        return binding.root
    }

    companion object {
        /**
         * Фабричный метод для создания фрагмента. Создавать фрагмент через конструктор нельзя
         * так как из-за особенностей Android, если он содержит аргументы, то он может быть не вызван
         * и аргументы будут потеряны.
         * Пример реализации фабричного метода с аргументами есть в SecondFragment.kt
         */
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}