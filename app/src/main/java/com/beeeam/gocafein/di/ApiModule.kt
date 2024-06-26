package com.beeeam.gocafein.di

import com.beeeam.data.api.GocafeinApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit): GocafeinApi {
        return retrofit.create(GocafeinApi::class.java)
    }
}
