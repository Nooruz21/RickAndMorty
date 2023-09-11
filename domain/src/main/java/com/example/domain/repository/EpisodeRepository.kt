package com.example.domain.repository

import com.example.domain.model.Episode
import com.example.domain.utils.RemotePagingWrapper

interface EpisodeRepository {
    fun fetchEpisode(name: String?): RemotePagingWrapper<Episode>
}