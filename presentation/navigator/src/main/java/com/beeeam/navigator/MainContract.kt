package com.beeeam.navigator

data class MainState(
    val sampleState: String = "",
)

sealed interface MainSideEffect {}