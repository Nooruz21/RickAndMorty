package com.example.rickandm.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandm.R
import com.example.rickandm.databinding.ItemCharactersBinding
import com.example.domain.model.Character
import com.example.rickandm.presentation.base.BaseDiffUtilItemCallback
import com.example.rickandm.presentation.ui.models.CharacterUI

class CharactersAdapter :
    PagingDataAdapter<CharacterUI, CharactersAdapter.CharactersViewHolder>(BaseDiffUtilItemCallback()) {

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
        fun bind(result: CharacterUI) = with(binding) {
            result.apply {
                progressImage.isVisible = true
                imageView.load(image){ listener { _, _ -> progressImage.isGone = true }}
                tvName.text = name
                tvStatus.text = status
                tvSpecies.text = species
                tvGender.text = gender
                when (status) {
                    "Alive" -> imageStatus.setImageResource(R.color.green)
                    "Dead" -> imageStatus.setImageResource(R.color.red)
                    "unknown" -> imageStatus.setImageResource(R.color.grey)
                }
                when (gender) {
                    "Male" -> imageGender.setImageResource(R.drawable.ic_male_gender)
                    "Female" -> imageGender.setImageResource(R.drawable.ic_female_gender)
                    "unknown" -> imageGender.setImageResource(R.color.grey)
                }
            }
        }
    }

}