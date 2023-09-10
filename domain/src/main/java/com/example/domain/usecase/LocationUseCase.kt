package com.example.domain.usecase

import com.example.domain.repository.RickAndMortyRepository

class LocationUseCase(private val repositoryLocation: RickAndMortyRepository) {
    operator fun invoke(name: String?) = repositoryLocation.getLocation(name)
}