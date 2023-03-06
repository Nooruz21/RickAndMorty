package com.example.rickandm.data.pagingsource

import com.example.rickandm.data.base.BasePagingSource
import com.example.rickandm.data.model.ResultDto
import com.example.rickandm.data.remote.RickAndMortyService
import com.example.rickandm.domain.model.Result

class CharacterPagingSource(
    private val service: RickAndMortyService,
    private val name: String?,
    private val status: String?,
    private val gender: String?,
    private val species: String?
) : BasePagingSource<ResultDto, Result>(
    {
        service.getAllCharacters(it, name, status, gender, species)
    }
)
