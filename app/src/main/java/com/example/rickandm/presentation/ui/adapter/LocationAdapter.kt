package com.example.rickandm.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rickandm.databinding.ItemLocationBinding
import com.example.rickandm.presentation.base.BaseDiffUtilItemCallback
import com.example.rickandm.presentation.ui.models.LocationUI

class LocationAdapter : PagingDataAdapter<LocationUI, LocationAdapter.LocationViewHolder>(
    BaseDiffUtilItemCallback()
) {
    class LocationViewHolder(private val binding: ItemLocationBinding) : ViewHolder(binding.root) {
        fun bind(location: LocationUI) = with(binding) {
            location.apply {
                tvNumber.text = id.toString()
                tvName.text = name
                tvDimension.text = dimension
                tvType.text = type
            }
        }
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}