package com.example.rickandm.presentation.utils

import android.app.Application
import com.example.rickandm.di.presentationModule
import com.example.rickandm.di.repositoryModule
import com.example.rickandm.di.useCaseModule
import com.example.rickandm.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(presentationModule, repositoryModule, useCaseModule, retrofitModule))
        }
    }
}