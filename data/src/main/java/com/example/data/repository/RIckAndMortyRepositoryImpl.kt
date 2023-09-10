package com.example.data.repository

import androidx.paging.PagingData
import com.example.data.base.BaseDataRepository
import com.example.data.pagingsource.CharacterPagingSource
import com.example.data.pagingsource.EpisodePagingSource
import com.example.data.pagingsource.LocationPagingSource
import com.example.data.remote.RickAndMortyService
import com.example.domain.model.Episode
import com.example.domain.model.Location
import com.example.domain.model.Character
import com.example.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class RIckAndMortyRepositoryImpl(private val apiService: RickAndMortyService) :
    RickAndMortyRepository,
    BaseDataRepository() {

    override fun getCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Character>> {
        return doPagingRequest(CharacterPagingSource(apiService, name, status, gender, species))
    }

    override fun getEpisode(name: String?): Flow<PagingData<Episode>> {
        return doPagingRequest(EpisodePagingSource(apiService, name))
    }

    override fun getLocation(name: String?): Flow<PagingData<Location>> {
        return doPagingRequest(LocationPagingSource(apiService, name))
    }


}