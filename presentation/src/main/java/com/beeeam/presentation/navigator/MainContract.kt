package com.beeeam.presentation.navigator

data class MainState(
    val toastVisible: Boolean = false,
    val toastMsg: String = "",
)

sealed interface MainSideEffect {}