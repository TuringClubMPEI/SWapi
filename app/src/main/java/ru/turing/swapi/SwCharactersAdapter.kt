package ru.turing.swapi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.turing.swapi.databinding.ItemSwCharacterBinding

class SwCharactersAdapter(
    private val routeToDataCharacterFragmentCallback: (character: CharacterData) -> Unit,
) : RecyclerView.Adapter<SwCharactersAdapter.SwCharacterViewHolder>() {

    private val _characters = mutableListOf<CharacterData>()
    val characters: List<CharacterData> = _characters

    @SuppressLint("NotifyDataSetChanged")
    fun addSwCharacters(characters: List<CharacterData>) {
        _characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SwCharacterViewHolder(
        ItemSwCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        routeToDataCharacterFragmentCallback
    )

    override fun onBindViewHolder(holder: SwCharacterViewHolder, position: Int) =
        holder.bind(_characters[position])

    override fun getItemCount() = _characters.size

    class SwCharacterViewHolder(
        private val binding: ItemSwCharacterBinding,
        private val routeToDataCharacterFragmentCallback: (character: CharacterData) -> Unit,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterData) = with(binding) {
            characterNameTextview.text = character.name
            routeToDetailsButton.setOnClickListener {
                routeToDataCharacterFragmentCallback(character)
            }
        }
    }
}