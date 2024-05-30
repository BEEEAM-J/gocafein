package com.beeeam.presentation.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.beeeam.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
) : ContainerHost<DetailState, DetailSideEffect>, ViewModel() {
    override val container: Container<DetailState, DetailSideEffect> = container(DetailState())

    private val movieId = savedStateHandle.get<String>(DetailRoute.detail)!!

    fun loadMovieDetail() = intent {
        getMovieDetailUseCase(movieId)
            .onSuccess {
                reduce { state.copy(movieDetail = it) }
            }
            .onFailure {

            }
    }

    fun popBackStack() = intent { postSideEffect(DetailSideEffect.PopBackStack) }
}

