package ru.turing.swapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.turing.swapi.databinding.FragmentDartVaderBinding
import ru.turing.swapi.databinding.FragmentLuckSkywalkerBinding
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
                (activity as ActivityNavigator).goToDartVaderFragment()
            }
        }

        binding.goToLuckSkywalkerFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToLuckSkywalkerFragment()
            }
        }

        binding.goToShivPalpatinFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToShivPalpatinFragment()
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainScreenFragment()
    }
}