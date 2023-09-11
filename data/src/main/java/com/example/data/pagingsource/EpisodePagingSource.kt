package com.example.data.pagingsource

import com.example.data.base.BasePagingSource
import com.example.data.model.EpisodeDto
import com.example.data.remote.apiservice.EpisodeApiService
import com.example.domain.model.Episode

class EpisodePagingSource(private val apiService: EpisodeApiService, name: String?) :
    BasePagingSource<EpisodeDto, Episode>({
        apiService.fetchEpisode(it, name)
    })
