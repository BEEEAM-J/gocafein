package com.beeeam.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.beeeam.presentation.detail.detailNavGraph
import com.beeeam.presentation.home.HomeRoute.homeRoute
import com.beeeam.presentation.home.homeNavGraph

@Composable
fun MainScreen(
    mainNavigator: MainNavigator = rememberMainNavigator()
) {
    NavHost(
        navController = mainNavigator.navController,
        startDestination = homeRoute
    ) {
        homeNavGraph(navigator = mainNavigator)
        detailNavGraph(navigator = mainNavigator)
    }

}

