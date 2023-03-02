package com.example.rickandm.data.repository

import androidx.paging.PagingData
import com.example.rickandm.data.base.BaseDataRepository
import com.example.rickandm.data.pagingsource.CharacterPagingSource
import com.example.rickandm.data.pagingsource.EpisodePagingSource
import com.example.rickandm.data.pagingsource.LocationPagingSource
import com.example.rickandm.data.remote.RickAndMortyService
import com.example.rickandm.domain.model.charactermodel.Result
import com.example.rickandm.domain.model.episodemodel.Episode
import com.example.rickandm.domain.model.locationmodel.Location
import com.example.rickandm.domain.repository.RickAndMortyRepository
import com.example.rickandm.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class RIckAndMortyRepositoryImpl(private val apiService: RickAndMortyService) :
    RickAndMortyRepository,
    BaseDataRepository() {
    override fun getCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Result>> {
        return doPagingRequest(CharacterPagingSource(apiService, name, status, gender, species))
    }

    override fun getCharacter(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<Resource<List<Result>>> = doRequest {
        apiService.getCharacter(name, status, gender, species).map { it.toDomain() }
    }

    override fun getEpisode(name: String?): Flow<PagingData<Episode>> {
        return doPagingRequest(EpisodePagingSource(apiService, name))
    }

    override fun getLocation(name: String?): Flow<PagingData<Location>> {
        return doPagingRequest(LocationPagingSource(apiService, name))
    }


}