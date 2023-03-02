package com.example.rickandm.di

import com.example.rickandm.presentation.viewmodel.AllViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AllViewModel(get(), get(), get())
    }

}