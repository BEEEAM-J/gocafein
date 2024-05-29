package com.beeeam.presentation.navigator

data class MainState(
    val sampleState: String = "",
)

sealed interface MainSideEffect {}