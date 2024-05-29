package com.beeeam.presentation.detail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.beeeam.presentation.detail.DetailRoute.detail

fun NavGraphBuilder.detailNavGraph(
) {
    composable(
        route = DetailRoute.detailRoute("{${detail}}"),
        arguments = listOf(
            navArgument(detail) {
                type = NavType.StringType
            },
        ),
    ) {
        DetailRoute()
    }
}

object DetailRoute {
    const val detail = "detail"
    fun detailRoute(id: String) = "detail/$id"
}