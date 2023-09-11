package com.example.data.remote

import com.example.data.base.BasePaginationInfo
import com.example.data.model.EpisodeDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int,
        @Query("name") name: String?,
    ): BasePaginationInfo<EpisodeDto>

}