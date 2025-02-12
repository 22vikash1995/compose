package com.example.composedemoapp.di

import com.example.composedemoapp.api.DemoAPi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getAPiProvider(retrofit: Retrofit): DemoAPi {
        return retrofit.create(DemoAPi::class.java)
    }

}