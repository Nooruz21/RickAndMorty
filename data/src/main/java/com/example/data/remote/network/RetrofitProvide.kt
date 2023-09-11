package com.example.data.remote.network

import com.example.data.remote.apiservice.CharacterApiService
import com.example.data.remote.apiservice.EpisodeApiService
import com.example.data.remote.apiservice.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitProvide {

    fun provideCharacterApi(): CharacterApiService {
        return provideRetrofit(provideClient()).create(CharacterApiService::class.java)
    }

    fun provideLocationApi(): LocationApiService {
        return provideRetrofit(provideClient()).create(LocationApiService::class.java)
    }

    fun provideEpisodeApi(): EpisodeApiService {
        return provideRetrofit(provideClient()).create(EpisodeApiService::class.java)
    }

    private fun provideRetrofit(okkHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").client(okkHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun provideClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor).build()
    }
}