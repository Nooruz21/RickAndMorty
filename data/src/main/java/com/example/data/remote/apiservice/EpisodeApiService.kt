package com.example.data.remote.apiservice

import com.example.data.base.BasePaginationInfo
import com.example.data.remote.dto.EpisodeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int,
        @Query("name") name: String?,
    ): BasePaginationInfo<EpisodeDto>

}