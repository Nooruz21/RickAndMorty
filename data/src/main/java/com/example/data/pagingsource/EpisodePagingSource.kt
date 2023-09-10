package com.example.data.pagingsource

import com.example.data.base.BasePagingSource
import com.example.data.model.EpisodeDto
import com.example.data.remote.RickAndMortyService
import com.example.domain.model.Episode

class EpisodePagingSource(private val apiService: RickAndMortyService, name: String?) :
    BasePagingSource<EpisodeDto, Episode>({
        apiService.getEpisode(it, name)
    })
