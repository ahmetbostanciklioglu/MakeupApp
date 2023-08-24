package com.ahmet.bostanciklioglu.makeupappkotlin.di

import com.ahmet.bostanciklioglu.makeupappkotlin.data.api.MakeupApiService
import com.ahmet.bostanciklioglu.makeupappkotlin.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): MakeupApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MakeupApiService::class.java)
    }
}


