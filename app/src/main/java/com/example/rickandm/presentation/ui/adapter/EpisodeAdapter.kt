package com.example.rickandm.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandm.databinding.ItemEpisodeBinding
import com.example.rickandm.presentation.base.BaseDiffUtilItemCallback
import com.example.rickandm.presentation.ui.models.EpisodeUI

class EpisodeAdapter :
    PagingDataAdapter<EpisodeUI, EpisodeAdapter.EpisodeViewHolder>(BaseDiffUtilItemCallback()) {
    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : ViewHolder(binding.root) {
        fun bind(episode: EpisodeUI) = with(binding) {
            episode.apply {
                tvNumber.text = id.toString()
                tvName.text = name
                tvEpisode.text = episode.episode
                tvAirData.text = airDate
            }
        }

    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}