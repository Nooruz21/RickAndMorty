package com.example.rickandm.data.remote

import com.example.rickandm.data.base.BasePagingResponse
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
    ): BasePagingResponse<ResultDto>

    @GET("character")
    suspend fun getAllCharacter(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?,
        @Query("species") species: String?,
    ): List<ResultDto>


    @GET("episode")
    suspend fun getAllEpisode(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePagingResponse<EpisodeDto>


    @GET("location")
    suspend fun getAllLocation(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePagingResponse<LocationDto>


}


