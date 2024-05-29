package com.beeeam.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.beeeam.presentation.navigator.MainNavigator

fun NavGraphBuilder.homeNavGraph(
    navigator: MainNavigator,
) {
    composable(HomeRoute.homeRoute) {
        HomeRoute(
            navigateToDetail = navigator::navigateToDetail
        )
    }
}

object HomeRoute {
    const val homeRoute = "home"
}
