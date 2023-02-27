package com.example.rickandm.domain.usecase

import com.example.rickandm.domain.repository.RickAndMortyRepository

class EpisodeUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllEpisode(name)
}