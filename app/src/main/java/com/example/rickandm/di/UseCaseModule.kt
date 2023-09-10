package com.example.rickandm.di

import com.example.domain.usecase.CharactersUseCase
import com.example.domain.usecase.EpisodeUseCase
import com.example.domain.usecase.LocationUseCase
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