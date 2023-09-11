package com.example.domain.usecase

import com.example.domain.repository.EpisodeRepository

class EpisodeUseCase(private val repository: EpisodeRepository) {
    operator fun invoke(name: String?) = repository.fetchEpisode(name)
}