package com.example.rickandm.presentation.ui.fragment.character

import com.example.domain.usecase.CharactersUseCase
import com.example.rickandm.presentation.base.BaseViewModel
import com.example.rickandm.presentation.ui.models.toUI

class CharacterViewModel(private val fetchCharacterUseCase: CharactersUseCase) : BaseViewModel() {
    fun fetchCharacter(
        name: String? = null,
        status: String? = null,
        species: String? = null,
        gender: String? = null,
    ) =
        fetchCharacterUseCase(name, status, species, gender).collectPagingRequest { it.toUI() }

}