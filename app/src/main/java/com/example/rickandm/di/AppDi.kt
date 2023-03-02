package com.example.rickandm.di

import com.example.rickandm.presentation.viewmodel.RickAndMortyViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        RickAndMortyViewModel(get(), get(), get())
    }
}