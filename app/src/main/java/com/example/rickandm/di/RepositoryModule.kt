package com.example.rickandm.di

import com.example.data.repository.RIckAndMortyRepositoryImpl
import com.example.domain.repository.RickAndMortyRepository
import org.koin.dsl.module

val repositoryModule  = module {

    single<RickAndMortyRepository> {
        RIckAndMortyRepositoryImpl(get())
    }

}