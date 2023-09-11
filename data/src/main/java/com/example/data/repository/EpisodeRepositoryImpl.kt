package com.example.data.repository

import com.example.data.base.BaseDataRepository
import com.example.data.pagingsource.EpisodePagingSource
import com.example.data.remote.EpisodeApiService
import com.example.domain.repository.EpisodeRepository

class EpisodeRepositoryImpl(private val service: EpisodeApiService) :
    BaseDataRepository(), EpisodeRepository {
    override fun fetchEpisode(name: String?) = doPagingRequest(EpisodePagingSource(service, name))
}