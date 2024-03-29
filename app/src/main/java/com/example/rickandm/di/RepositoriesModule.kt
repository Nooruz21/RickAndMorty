package com.example.rickandm.di

import com.example.data.repository.CharacterRepositoryImpl
import com.example.data.repository.EpisodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.domain.repository.CharacterRepository
import com.example.domain.repository.EpisodeRepository
import com.example.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCharacterRepository(
        repositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    abstract fun bindLocationRepository(
        repositoryImpl: LocationRepositoryImpl
    ): LocationRepository

    @Binds
    abstract fun bindEpisodeRepository(
        repositoryImpl: EpisodeRepositoryImpl
    ): EpisodeRepository
}