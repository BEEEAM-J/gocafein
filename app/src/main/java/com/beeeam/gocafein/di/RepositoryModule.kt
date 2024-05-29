package com.beeeam.gocafein.di

import com.beeeam.data.repositoryimpl.MovieDetailRepoImpl
import com.beeeam.data.repositoryimpl.MovieSearchRepoImpl
import com.beeeam.domain.repository.MovieDetailRepo
import com.beeeam.domain.repository.MovieSearchRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieListRepo(repoImpl: MovieSearchRepoImpl): MovieSearchRepo

    @Binds
    abstract fun bindMovieDetailRepo(repoImpl: MovieDetailRepoImpl): MovieDetailRepo
}