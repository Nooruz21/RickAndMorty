package com.example.rickandm.di

import com.example.rickandm.presentation.ui.fragment.character.CharacterViewModel
import com.example.rickandm.presentation.ui.fragment.episode.EpisodeViewModel
import com.example.rickandm.presentation.ui.fragment.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CharacterViewModel(fetchCharacterUseCase = get())
    }

    viewModel {
        LocationViewModel(fetchLocationUseCase = get())
    }

    viewModel {
        EpisodeViewModel(fetchEpisodeUseCase = get())
    }
}