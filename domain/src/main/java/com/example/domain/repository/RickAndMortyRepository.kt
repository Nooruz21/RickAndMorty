package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Character
import com.example.domain.model.Episode
import com.example.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Character>>

    fun getEpisode(name: String?): Flow<PagingData<Episode>>
    fun getLocation(name: String?): Flow<PagingData<Location>>


}