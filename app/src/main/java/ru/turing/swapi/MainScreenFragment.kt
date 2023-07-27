package ru.turing.swapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import ru.turing.swapi.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)

        binding.goToDartVaderFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToDataFragment(
                    CharacterData(
                        getString(R.string.dart_vader_text),
                        ResourcesCompat.getDrawable(resources, R.drawable.darth_vader, null)
                )
                )
            }
        }

        binding.goToLukSkywalkerFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToDataFragment(
                    CharacterData(
                        getString(R.string.luk_skywalker_text),
                        ResourcesCompat.getDrawable(resources, R.drawable.luk_skywalker, null)
                    )
                )
            }
        }

        binding.goToShivPalpatinFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToDataFragment(
                    CharacterData(
                        getString(R.string.shiv_palpatin_text),
                        ResourcesCompat.getDrawable(resources, R.drawable.shiv_palpatin, null)
                    )
                )
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainScreenFragment()
    }
}