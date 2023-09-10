package com.example.domain.usecase

import com.example.domain.repository.RickAndMortyRepository

class EpisodeUseCase(private val repositoryEpisode: RickAndMortyRepository) {
    operator fun invoke(name: String?) = repositoryEpisode.getEpisode(name)
}