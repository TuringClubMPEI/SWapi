package ru.turing.swapi

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.FragmentActivity
import ru.turing.swapi.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    private fun goToCharacterButtonClick(CharacterTextId: Int, CharacterDrawableId: Int, activity: FragmentActivity?) {
        if (activity is ActivityNavigator) {
            (activity as ActivityNavigator).goToDataFragment(
                CharacterData(
                    getString(CharacterTextId),
                    ResourcesCompat.getDrawable(resources, CharacterDrawableId, null)
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        binding.goToDartVaderFragment.setOnClickListener {
            goToCharacterButtonClick(R.string.dart_vader_text, R.drawable.darth_vader, activity)
        }

        binding.goToLukSkywalkerFragment.setOnClickListener {
            goToCharacterButtonClick(R.string.luk_skywalker_text, R.drawable.luk_skywalker, activity)
        }

        binding.goToShivPalpatinFragment.setOnClickListener {
            goToCharacterButtonClick(R.string.shiv_palpatin_text, R.drawable.shiv_palpatin, activity)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainScreenFragment()
    }
}