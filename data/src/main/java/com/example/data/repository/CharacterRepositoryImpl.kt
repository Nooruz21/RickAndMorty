package com.example.data.repository

import com.example.data.base.BaseDataRepository
import com.example.data.remote.pagingsource.CharacterPagingSource
import com.example.data.remote.apiservice.CharacterApiService
import com.example.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterApiService
) : BaseDataRepository(), CharacterRepository {

    override fun fetchCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = doPagingRequest(CharacterPagingSource(service, name, status, gender, species))

}