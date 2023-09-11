package com.example.rickandm.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.PreferencesButton
import com.example.data.remote.network.RetrofitProvide
import com.example.data.repository.CharacterRepositoryImpl
import com.example.data.repository.EpisodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.domain.repository.CharacterRepository
import com.example.domain.repository.EpisodeRepository
import com.example.domain.repository.LocationRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single<CharacterRepository> {
        CharacterRepositoryImpl(characterApi = get())
    }
    single<LocationRepository> {
        LocationRepositoryImpl(service = get())
    }
    single<EpisodeRepository> {
        EpisodeRepositoryImpl(service = get())
    }

    single { RetrofitProvide().provideCharacterApi() }
    single { RetrofitProvide().provideLocationApi() }
    single { RetrofitProvide().provideEpisodeApi() }


    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            "filter",
            Context.MODE_PRIVATE
        )
    }
    factory { provideSharedPreferences(get()) }
}

fun provideSharedPreferences(sharedPreferences: SharedPreferences): PreferencesButton {
    return PreferencesButton(sharedPreferences)
}