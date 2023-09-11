package com.example.rickandm.di

import com.example.domain.usecase.CharactersUseCase
import com.example.domain.usecase.EpisodeUseCase
import com.example.domain.usecase.LocationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        CharactersUseCase(repository = get())
    }
    factory {
        EpisodeUseCase(repository = get())
    }
    factory {
        LocationUseCase(repository = get())
    }

}