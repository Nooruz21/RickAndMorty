package com.example.rickandm.di

import com.example.rickandm.domain.usecase.CharactersUseCase
import com.example.rickandm.domain.usecase.EpisodeUseCase
import com.example.rickandm.domain.usecase.LocationUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        CharactersUseCase(repositoryCharacter = get())
    }
    factory {
        EpisodeUseCase(repositoryEpisode = get())
    }
    factory {
        LocationUseCase(repositoryLocation = get())
    }

}