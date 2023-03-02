package com.example.rickandm.presentation.utils

import android.app.Application
import com.example.rickandm.di.appModule
import com.example.rickandm.di.dataModule
import com.example.rickandm.di.domainModule
import com.example.rickandm.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule, networkModule))
        }
    }
}