package com.example.data.pagingsource

import com.example.data.base.BasePagingSource
import com.example.data.model.CharacterDto
import com.example.data.remote.RickAndMortyService
import com.example.domain.model.Character

class CharacterPagingSource(
    private val service: RickAndMortyService,
    private val name: String?,
    private val status: String?,
    private val gender: String?,
    private val species: String?
) : BasePagingSource<CharacterDto, Character>(
    {
        service.getAllCharacters(it, name, status, gender, species)
    }
)
