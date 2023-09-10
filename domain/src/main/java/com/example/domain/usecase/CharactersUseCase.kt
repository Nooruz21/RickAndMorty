package com.example.rickandm.domain.usecase

import com.example.domain.repository.RickAndMortyRepository

class CharactersUseCase(private val repositoryCharacter: RickAndMortyRepository) {
    operator fun invoke(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = repositoryCharacter.getCharacters(name, status, gender, species)

}