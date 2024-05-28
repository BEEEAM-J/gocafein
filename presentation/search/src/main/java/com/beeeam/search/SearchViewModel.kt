package com.beeeam.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ContainerHost<SearchState, SearchSideEffect>, ViewModel() {
    override val container: Container<SearchState, SearchSideEffect> = container(SearchState())

    @OptIn(OrbitExperimental::class)
    fun updateSearchValue(searchValue: String) = blockingIntent {
        reduce { state.copy(searchValue = searchValue) }
    }
}