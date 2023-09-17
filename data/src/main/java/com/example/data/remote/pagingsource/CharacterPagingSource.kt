package com.example.data.remote.pagingsource

import com.example.data.base.BasePagingSource
import com.example.data.remote.dto.CharacterDto
import com.example.data.remote.apiservice.CharacterApiService
import com.example.domain.model.Character

class CharacterPagingSource(
    private val service: CharacterApiService,
    private val name: String?,
    private val status: String?,
    private val gender: String?,
    private val species: String?
) : BasePagingSource<CharacterDto, Character>(
    {
        service.fetchCharacters(it, name, status, gender, species)
    }
)
