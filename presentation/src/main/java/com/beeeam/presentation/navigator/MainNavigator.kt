package com.beeeam.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.beeeam.presentation.detail.DetailRoute.detailRoute

class MainNavigator(
    val navController: NavHostController
) {
    fun navigateToDetail(id: String) {
        navController.navigate(detailRoute(id))
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
