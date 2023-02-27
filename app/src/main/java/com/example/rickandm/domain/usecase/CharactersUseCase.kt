package com.example.rickandm.domain.usecase

import com.example.rickandm.domain.repository.RickAndMortyRepository

class CharactersUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {
    operator fun invoke(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = rickAndMortyRepository.getAllCharacters(name, status, gender, species)
}