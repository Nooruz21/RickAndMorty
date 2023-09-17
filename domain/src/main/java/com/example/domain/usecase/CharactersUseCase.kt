package com.example.domain.usecase

import com.example.domain.repository.CharacterRepository
import javax.inject.Inject

class CharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = repository.fetchCharacters(name, status, gender, species)

}