package com.beeeam.presentation.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.beeeam.presentation.detail.DetailRoute.detail
import com.beeeam.presentation.navigator.MainNavigator

fun NavGraphBuilder.detailNavGraph(
    navigator: MainNavigator,
) {
    composable(
        route = DetailRoute.detailRoute("{${detail}}"),
        arguments = listOf(
            navArgument(detail) {
                type = NavType.StringType
            },
        ),
    ) {
        DetailRoute(
            popBackStack = navigator::popBackStack
        )
    }
}

object DetailRoute {
    const val detail = "detail"
    fun detailRoute(id: String) = "detail/$id"
}