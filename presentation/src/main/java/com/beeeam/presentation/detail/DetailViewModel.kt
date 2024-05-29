package com.beeeam.presentation.detail

import androidx.lifecycle.ViewModel
import com.beeeam.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
) : ContainerHost<DetailState, DetailSideEffect>, ViewModel() {
    override val container: Container<DetailState, DetailSideEffect> = container(DetailState())

}