package com.example.rickandm.presentation.ui.fragment.character

import com.example.domain.model.CharacterSort
import com.example.domain.usecase.CharactersUseCase
import com.example.rickandm.presentation.base.BaseViewModel
import com.example.rickandm.presentation.ui.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val fetchCharacterUseCase: CharactersUseCase
) : BaseViewModel() {

    private var characterFilter = CharacterSort()
    private var characterName = ""

    fun fetchCharacter(
        name: String? = null,
        status: String? = null,
        species: String? = null,
        gender: String? = null,
    ) = fetchCharacterUseCase(name, status, species, gender).collectPagingRequest { it.toUI() }

    fun setCharacterFilters(filter: CharacterSort) {
        characterFilter = filter
        fetchCharacter(
            characterName,
            characterFilter.status,
            characterFilter.species,
            characterFilter.gender
        )
    }

    fun setCharacterName(name: String) {
        characterName = name
        fetchCharacter(
            characterName,
            characterFilter.status,
            characterFilter.species,
            characterFilter.gender
        )
    }
}