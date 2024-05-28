package com.beeeam.gocafein.di

import com.beeeam.data.repositoryimpl.MovieListRepoImpl
import com.beeeam.domain.repository.MovieListRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieListRepo(repoImpl: MovieListRepoImpl): MovieListRepo
}