package com.beeeam.presentation.home

import androidx.lifecycle.ViewModel
import com.beeeam.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase,
) : ContainerHost<SearchState, SearchSideEffect>, ViewModel() {
    override val container: Container<SearchState, SearchSideEffect> = container(SearchState())

    fun loadMovieList(title: String) = intent {
        getMovieListUseCase(title, 1)
            .onSuccess {
                reduce { state.copy(movieList = it.Search) }
            }
            .onFailure {

            }
    }

    @OptIn(OrbitExperimental::class)
    fun updateSearchValue(searchValue: String) = blockingIntent {
        reduce { state.copy(searchValue = searchValue) }
    }
}