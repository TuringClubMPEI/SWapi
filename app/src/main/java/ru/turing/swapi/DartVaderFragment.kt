package ru.turing.swapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.turing.swapi.databinding.FragmentDartVaderBinding
import ru.turing.swapi.databinding.FragmentLuckSkywalkerBinding

class DartVaderFragment : Fragment() {

    private lateinit var binding: FragmentDartVaderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDartVaderBinding.inflate(inflater, container, false)

        binding.fromDartVaderFragmentToMainFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToMainFragment()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = DartVaderFragment()
    }
}