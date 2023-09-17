package com.example.data.repository

import com.example.data.base.BaseDataRepository
import com.example.data.remote.pagingsource.EpisodePagingSource
import com.example.data.remote.apiservice.EpisodeApiService
import com.example.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val service: EpisodeApiService
) : BaseDataRepository(), EpisodeRepository {
    override fun fetchEpisode(name: String?) = doPagingRequest(EpisodePagingSource(service, name))
}