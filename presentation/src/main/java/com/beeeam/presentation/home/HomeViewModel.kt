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

    fun loadMovieList(title: String, page: Int) = intent {
        reduce { state.copy(isLoading = true) }
        getMovieListUseCase(title, page)
            .onSuccess {
                when(it.Error) {
                    "Too many results." -> postSideEffect(HomeSideEffect.ShowToastManyResult)
                    "Movie not found!" -> postSideEffect(HomeSideEffect.ShowToastNotFound)
                    else -> reduce { state.copy(movieList = it.Search, isLoading = false) }
                }
            }
            .onFailure {

            }
    }

    fun updateMovieListPage(page: Int) = intent {
        Log.d("input page", "$page")
        reduce { state.copy(movieListPage = page + 1) }
        Log.d("updated page", "${state.movieListPage}")
    }


    @OptIn(OrbitExperimental::class)
    fun updateSearchValue(searchValue: String) = blockingIntent {
        reduce { state.copy(searchValue = searchValue) }
    }

    fun navigateToDetail(id: String) = intent { postSideEffect(HomeSideEffect.NavigateToDetail(id = id)) }
}