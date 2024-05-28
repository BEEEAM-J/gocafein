package com.beeeam.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beeeam.search.SearchRoute

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainNavigator.Search.route
    ) {
        composable(MainNavigator.Search.route) {
            SearchRoute()
        }
        composable(MainNavigator.Detail.route) {
//            Detail()
        }
    }
}