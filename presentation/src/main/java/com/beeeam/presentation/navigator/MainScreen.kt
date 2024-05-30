package com.beeeam.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import com.beeeam.presentation.detail.detailNavGraph
import com.beeeam.presentation.home.HomeRoute.homeRoute
import com.beeeam.presentation.home.homeNavGraph
import com.beeeam.presentation.navigator.component.GocafeinToast
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    mainNavigator: MainNavigator = rememberMainNavigator()
) {
    val uiState = viewModel.collectAsState().value

    NavHost(
        navController = mainNavigator.navController,
        startDestination = homeRoute
    ) {
        homeNavGraph(
            navigator = mainNavigator,
            onShowToast = viewModel::onShowToast,
        )
        detailNavGraph(navigator = mainNavigator)
    }

    GocafeinToast(
        visible = uiState.toastVisible,
        msg = uiState.toastMsg,
    )
}

