package com.example.rickandm.domain.repository

import androidx.paging.PagingData
import com.example.rickandm.domain.model.Result
import com.example.rickandm.domain.model.Episode
import com.example.rickandm.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Result>>

    fun getEpisode(name: String?): Flow<PagingData<Episode>>
    fun getLocation(name: String?): Flow<PagingData<Location>>


}