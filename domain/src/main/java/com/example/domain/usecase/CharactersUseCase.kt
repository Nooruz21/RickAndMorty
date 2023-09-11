package com.example.domain.usecase

import com.example.domain.repository.CharacterRepository

class CharactersUseCase(private val repository: CharacterRepository) {
    operator fun invoke(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = repository.fetchCharacters(name, status, gender, species)

}