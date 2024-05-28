package com.beeeam.gocafein.di

import com.beeeam.domain.repository.MovieListRepo
import com.beeeam.domain.usecase.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMovieList(repo: MovieListRepo): GetMovieListUseCase {
        return GetMovieListUseCase(repo)
    }
}