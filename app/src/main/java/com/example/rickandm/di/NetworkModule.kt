package com.example.rickandm.di

import com.example.data.remote.apiservice.LocationApiService
import com.example.data.remote.network.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideCharacterService(
        networkClient: NetworkClient
    ) = networkClient.provideCharacterApiService()

    @Singleton
    @Provides
    fun provideLocationApiService(
        networkClient: NetworkClient
    ): LocationApiService {
        return networkClient.provideLocationApiService()
    }

    @Singleton
    @Provides
    fun provideEpisodeApiService(
        networkClient: NetworkClient
    ) = networkClient.provideEpisodeApiService()


}