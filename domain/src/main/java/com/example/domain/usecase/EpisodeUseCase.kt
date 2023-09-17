package com.example.domain.usecase

import com.example.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeUseCase @Inject constructor(
    private val repository: EpisodeRepository
) {
    operator fun invoke(name: String?) = repository.fetchEpisode(name)
}