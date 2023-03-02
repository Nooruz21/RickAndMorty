package com.example.rickandm.di

import com.example.rickandm.data.repository.RIckAndMortyRepositoryImpl
import com.example.rickandm.domain.repository.RickAndMortyRepository
import org.koin.dsl.module

val repositoryModule  = module {

    single<RickAndMortyRepository> {
        RIckAndMortyRepositoryImpl(get())
    }

}