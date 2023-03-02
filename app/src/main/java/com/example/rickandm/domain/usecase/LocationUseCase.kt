package com.example.rickandm.domain.usecase

import com.example.rickandm.domain.repository.RickAndMortyRepository

class LocationUseCase(private val repositoryLocation: RickAndMortyRepository) {
    operator fun invoke(name: String?) = repositoryLocation.getLocation(name)
}