package com.example.rickandm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandm.databinding.ItemEpisodeBinding
import com.example.rickandm.domain.model.episodemodel.Episode

class EpisodeAdapter :
    PagingDataAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(LocationModelItemCallback) {
    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : ViewHolder(binding.root) {
        fun bind(episode: Episode) = with(binding) {
            episode.apply {
                tvNumber.text = id.toString()
                tvName.text = name
                tvEpisode.text = episode.episode
                tvAirData.text = air_date
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

    private object LocationModelItemCallback : DiffUtil.ItemCallback<Episode>() {
        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name
        }

    }
}