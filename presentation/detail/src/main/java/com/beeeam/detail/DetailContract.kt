package com.beeeam.detail

data class DetailState(
    val sampleState: String = "",
)

sealed interface DetailSideEffect {}