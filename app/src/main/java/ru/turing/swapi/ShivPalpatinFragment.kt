package ru.turing.swapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.turing.swapi.databinding.FragmentDartVaderBinding
import ru.turing.swapi.databinding.FragmentLuckSkywalkerBinding
import ru.turing.swapi.databinding.FragmentShivPalpatinBinding
import ru.turing.swapi.databinding.FragmentMainScreenBinding

class ShivPalpatinFragment : Fragment() {

    private lateinit var binding: FragmentShivPalpatinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShivPalpatinBinding.inflate(inflater, container, false)

        binding.fromShivPalpatinFragmentToMainFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToMainFragment()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ShivPalpatinFragment()
    }
}