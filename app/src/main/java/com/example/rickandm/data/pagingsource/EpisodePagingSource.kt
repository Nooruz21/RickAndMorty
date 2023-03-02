package com.example.rickandm.data.pagingsource

import com.example.rickandm.data.base.BasePagingSource
import com.example.rickandm.data.model.episode.EpisodeDto
import com.example.rickandm.data.remote.RickAndMortyService
import com.example.rickandm.domain.model.episodemodel.Episode

class EpisodePagingSource(private val apiService: RickAndMortyService, name: String?) :
    BasePagingSource<EpisodeDto, Episode>({
        apiService.getEpisode(it, name)
    })
