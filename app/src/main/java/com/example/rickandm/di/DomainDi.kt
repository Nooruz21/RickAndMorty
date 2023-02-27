package com.example.rickandm.di

import com.example.rickandm.domain.usecase.CharactersUseCase
import com.example.rickandm.domain.usecase.EpisodeUseCase
import com.example.rickandm.domain.usecase.LocationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        CharactersUseCase(rickAndMortyRepository = get())
    }
    factory {
        EpisodeUseCase(rickAndMortyRepository = get())
    }
    factory {
        LocationUseCase(rickAndMortyRepository = get())
    }

   }