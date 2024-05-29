package com.beeeam.gocafein.di

import com.beeeam.domain.repository.MovieDetailRepo
import com.beeeam.domain.repository.MovieSearchRepo
import com.beeeam.domain.usecase.GetMovieDetailUseCase
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
    fun provideGetMovieList(repo: MovieSearchRepo): GetMovieListUseCase {
        return GetMovieListUseCase(repo)
    }

    @Singleton
    @Provides
    fun provideGetMovieDetail(repo: MovieDetailRepo): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(repo)
    }
}