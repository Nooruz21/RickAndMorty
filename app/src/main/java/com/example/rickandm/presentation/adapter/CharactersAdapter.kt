package com.example.rickandm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandm.R
import com.example.rickandm.databinding.ItemCharactersBinding
import com.example.domain.model.Character

class CharactersAdapter :
    PagingDataAdapter<Character, CharactersAdapter.CharactersViewHolder>(CharacterModelItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharactersViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Character) = with(binding) {
            result.apply {
                imageCharacter.load(image)
                nameCharacter.text = name
                when (status) {
                    "Alive" -> imageStatus.setImageResource(R.drawable.ic_alive_status)
                    "Dead" -> imageStatus.setImageResource(R.drawable.ic_dead_status)
                    "unknown" -> imageStatus.setImageResource(R.drawable.ic_unknown_status)
                }
                statusCharacter.text =
                    statusCharacter.context.getString(
                        R.string.character_status,
                        status,
                        species
                    )
                tvLocation.text = location.name
                tvCreate.text = created
            }
        }
    }

    private object CharacterModelItemCallback : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id && oldItem.image == newItem.image
        }

    }
}