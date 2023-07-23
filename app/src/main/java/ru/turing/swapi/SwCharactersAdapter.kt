package ru.turing.swapi

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.turing.swapi.databinding.ItemSwCharacterBinding

class SwCharactersAdapter(
    private val routeToAnotherFragmentCallback: () -> Unit,
) : RecyclerView.Adapter<SwCharactersAdapter.SwCharacterViewHolder>() {

    private val _characters = mutableListOf<SwCharacter>()
    val characters: List<SwCharacter> = _characters

    @SuppressLint("NotifyDataSetChanged")
    fun addSwCharacters(characters: List<SwCharacter>) {
        _characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SwCharacterViewHolder(
        ItemSwCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        routeToAnotherFragmentCallback
    )

    override fun onBindViewHolder(holder: SwCharacterViewHolder, position: Int) =
        holder.bind(_characters[position])

    override fun getItemCount() = _characters.size

    class SwCharacterViewHolder(
        private val binding: ItemSwCharacterBinding,
        private val routeToAnotherFragmentCallback: () -> Unit,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(character: SwCharacter) = with(binding) {
            title.text = character.name
            description.text = character.description
            routeToDetailsButton.setOnClickListener {
                routeToAnotherFragmentCallback()
            }
        }
    }
}