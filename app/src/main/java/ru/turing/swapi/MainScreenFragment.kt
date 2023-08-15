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

        val adapter = SwCharactersAdapter {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, DataFragment.newInstance(it))
                .commit()
        }
        binding.charactersRecyclerView.adapter = adapter

        adapter.addSwCharacters(
            listOf(
                CharacterData(
                    getString(R.string.luk_skywalker_name),
                    getString(R.string.luk_skywalker_text),
                    ResourcesCompat.getDrawable(resources, R.drawable.luk_skywalker, null)
                ),
                CharacterData(
                    getString(R.string.shiv_palpatin_name),
                    getString(R.string.shiv_palpatin_text),
                    ResourcesCompat.getDrawable(resources, R.drawable.shiv_palpatin, null)
                ),
                CharacterData(
                    getString(R.string.dart_vader_name),
                    getString(R.string.dart_vader_text),
                    ResourcesCompat.getDrawable(resources, R.drawable.darth_vader, null)
                )
            )
        )

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainScreenFragment()
    }
}