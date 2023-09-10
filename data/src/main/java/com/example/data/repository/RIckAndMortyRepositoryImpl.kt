package com.example.data.repository

import com.example.data.base.BaseDataRepository
import com.example.data.pagingsource.CharacterPagingSource
import com.example.data.pagingsource.EpisodePagingSource
import com.example.data.pagingsource.LocationPagingSource
import com.example.data.remote.RickAndMortyService
import com.example.domain.repository.RickAndMortyRepository

class RIckAndMortyRepositoryImpl(private val apiService: RickAndMortyService) :
    RickAndMortyRepository,
    BaseDataRepository() {

    override fun getCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = doPagingRequest(CharacterPagingSource(apiService, name, status, gender, species))


    override fun getEpisode(name: String?) = doPagingRequest(EpisodePagingSource(apiService, name))


    override fun getLocation(name: String?) =
        doPagingRequest(LocationPagingSource(apiService, name))

}