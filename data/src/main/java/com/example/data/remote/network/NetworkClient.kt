package com.example.data.remote.network

import com.example.data.remote.apiservice.CharacterApiService
import com.example.data.remote.apiservice.EpisodeApiService
import com.example.data.remote.apiservice.LocationApiService
import retrofit2.create
import javax.inject.Inject

class NetworkClient @Inject constructor() {

    private val provideRetrofit = provideRetrofit(
        provideOkHttpClientBuilder().build()
    )

    fun provideCharacterApiService(): CharacterApiService = provideRetrofit.create()

    fun provideLocationApiService(): LocationApiService = provideRetrofit.create()

    fun provideEpisodeApiService(): EpisodeApiService = provideRetrofit.create()

}