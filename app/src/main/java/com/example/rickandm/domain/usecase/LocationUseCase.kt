package com.example.rickandm.domain.usecase

import com.example.rickandm.domain.repository.RickAndMortyRepository

class LocationUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllLocation(name)
}