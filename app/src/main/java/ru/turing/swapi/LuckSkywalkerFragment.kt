package ru.turing.swapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.turing.swapi.databinding.FragmentLuckSkywalkerBinding

class LuckSkywalkerFragment : Fragment() {

    private lateinit var binding: FragmentLuckSkywalkerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLuckSkywalkerBinding.inflate(inflater, container, false)

        binding.fromLukSkywalkerFragmentToMainFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToMainFragment()
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = LuckSkywalkerFragment()
    }
}