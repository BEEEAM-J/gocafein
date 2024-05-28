package com.beeeam.navigator

sealed class MainNavigator(val route: String) {
    object Search : MainNavigator("search")
    object Detail : MainNavigator("detail")
}