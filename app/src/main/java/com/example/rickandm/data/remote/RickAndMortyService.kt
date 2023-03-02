package com.example.rickandm.data.remote

import com.example.rickandm.data.base.BasePaginationInfo
import com.example.rickandm.data.model.characters.ResultDto
import com.example.rickandm.data.model.episode.EpisodeDto
import com.example.rickandm.data.model.location.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?,
        @Query("species") species: String?,
    ): BasePaginationInfo<ResultDto>

    @GET("character")
    suspend fun getCharacter(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?,
        @Query("species") species: String?,
    ): List<ResultDto>


    @GET("episode")
    suspend fun getEpisode(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePaginationInfo<EpisodeDto>


    @GET("location")
    suspend fun getLocation(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePaginationInfo<LocationDto>


}


