package ru.turing.swapi

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import ru.turing.swapi.databinding.FragmentDataBinding

class DataFragment : Fragment() {

    private lateinit var binding: FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDataBinding.inflate(inflater, container, false)

        val character = arguments?.getSerializable(ARG_CHARACTER_DATA) as CharacterData
        binding.dataText.text = character.description
        binding.dataImage.setImageDrawable(character.image)


        binding.buttonToMainFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToMainFragment()
            }
        }

        return binding.root
    }

    companion object {
        private const val ARG_CHARACTER_DATA = "arg_character_data"

        @JvmStatic
        fun newInstance(character: CharacterData) =
            DataFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CHARACTER_DATA, character)
                }
            }
    }
}