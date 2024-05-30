package com.beeeam.presentation.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.beeeam.presentation.navigator.MainNavigator

fun NavGraphBuilder.homeNavGraph(
    navigator: MainNavigator,
    onShowToast: (String) -> Unit,
) {
    composable(HomeRoute.homeRoute) {
        HomeRoute(
            onShowToast = onShowToast,
            navigateToDetail = navigator::navigateToDetail
        )
    }
}

object HomeRoute {
    const val homeRoute = "home"
}
