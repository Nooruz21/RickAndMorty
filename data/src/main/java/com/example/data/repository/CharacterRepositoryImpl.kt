package com.example.data.repository

import com.example.data.base.BaseDataRepository
import com.example.data.pagingsource.CharacterPagingSource
import com.example.data.remote.apiservice.CharacterApiService
import com.example.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val characterApi: CharacterApiService) :
    BaseDataRepository(), CharacterRepository {

    override fun fetchCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = doPagingRequest(CharacterPagingSource(characterApi, name, status, gender, species))

}