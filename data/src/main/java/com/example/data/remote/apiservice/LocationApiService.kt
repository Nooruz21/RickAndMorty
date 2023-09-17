package com.example.data.remote.apiservice

import com.example.data.base.BasePaginationInfo
import com.example.data.remote.dto.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("location")
    suspend fun fetchLocation(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePaginationInfo<LocationDto>

}