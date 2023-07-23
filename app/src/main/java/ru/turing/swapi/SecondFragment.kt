package ru.turing.swapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.turing.swapi.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        val character = arguments?.getSerializable(ARG_FROM_FIRST) as SwCharacter

        binding.button.text = character.name

        binding.button.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToFirstFragment()
            }
        }

        return binding.root
    }

    companion object {

        const val ARG_FROM_FIRST = "arg_from_fragment"

        fun newInstance(character: SwCharacter) = SecondFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARG_FROM_FIRST, character)
            }
        }
    }

}