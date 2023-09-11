package com.example.data.remote

import com.example.data.base.BasePaginationInfo
import com.example.data.model.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character")
    suspend fun fetchCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("gender") gender: String?,
    ): BasePaginationInfo<CharacterDto>

}