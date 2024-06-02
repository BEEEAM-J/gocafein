package com.beeeam.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.beeeam.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {
    override val container: Container<HomeState, HomeSideEffect> = container(HomeState())
    private var searchValue: String = "star"

    fun loadMovieList(needClear: Boolean) = intent {
        reduce { state.copy(isLoading = true) }

        if (needClear) reduce { state.copy(movieListPage = 1) }

        getMovieListUseCase(searchValue, state.movieListPage)
            .onSuccess {
                reduce {
                    state.copy(
                        movieList = if (needClear) it.search.distinctBy { it.movieId } else (state.movieList + it.search).distinctBy { it.movieId },
                        movieListPage = state.movieListPage + 1
                    )
                }
            }
            .onFailure {
                when (it.message) {
                    "Too many results." -> postSideEffect(HomeSideEffect.ShowToastManyResult)
                    "Movie not found!" -> postSideEffect(HomeSideEffect.ShowToastNotFound)
                    else -> postSideEffect(HomeSideEffect.ShowUnknownError)
                }
            }

        reduce { state.copy(isLoading = false,) }
    }

    fun search() = intent {
        this@HomeViewModel.searchValue = state.searchValue
        loadMovieList(true)
    }


    @OptIn(OrbitExperimental::class)
    fun updateSearchValue(searchValue: String) = blockingIntent {
        reduce { state.copy(searchValue = searchValue) }
    }


    fun navigateToDetail(id: String) =
        intent { postSideEffect(HomeSideEffect.NavigateToDetail(id = id)) }
}