package com.example.rickandm.domain.usecase

import com.example.rickandm.domain.repository.RickAndMortyRepository

class EpisodeUseCase(private val repositoryEpisode: RickAndMortyRepository) {
    operator fun invoke(name: String?) = repositoryEpisode.getEpisode(name)
}