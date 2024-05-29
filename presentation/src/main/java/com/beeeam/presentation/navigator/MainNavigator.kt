package com.beeeam.presentation.navigator

sealed class MainNavigator(val route: String) {
    object Search : MainNavigator("search")
    object Detail : MainNavigator("detail")
}