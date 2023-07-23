package ru.turing.swapi

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

        when (arguments?.getString(ARG_FROM_MAIN) ?: "") {
            "dart_vader" -> {
                binding.dataText.text = R.string.dart_vader_text.toString()
                binding.dataImage.setImageDrawable(R.drawable.darth_vader.toDrawable())
            }

            "shiv_palpatin" -> {
                binding.dataText.text = R.string.shiv_palpatin_text.toString()
                binding.dataImage.setImageDrawable(R.drawable.mp_palpatine.toDrawable())
            }

            "luk_skywalker" -> {
                binding.dataText.text = R.string.luk_skywaalker_text.toString()
                binding.dataImage.setImageDrawable(R.drawable.luke_skywalker.toDrawable())
            }
        }

        binding.buttonToMainFragment.setOnClickListener {
            if (activity is ActivityNavigator) {
                (activity as ActivityNavigator).goToMainFragment()
            }
        }

        return binding.root
    }

    companion object {
        private const val ARG_FROM_MAIN = "arg_from_main"

        @JvmStatic
        fun newInstance(character: String) =
            DataFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FROM_MAIN, character)
                }
            }
    }
}