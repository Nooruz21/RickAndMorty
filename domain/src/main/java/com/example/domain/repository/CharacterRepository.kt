package com.example.domain.repository

import com.example.domain.model.Character
import com.example.domain.utils.RemotePagingWrapper

interface CharacterRepository {

    fun fetchCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): RemotePagingWrapper<Character>


}