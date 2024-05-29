package com.beeeam.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beeeam.presentation.home.component.GocafeinSearchBar
import com.beeeam.presentation.home.component.MovieItem
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun HomeRoute(
    navigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val uiState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is HomeSideEffect.NavigateToDetail -> navigateToDetail(sideEffect.id)
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.loadMovieList("star")
    }

    HomeScreen(
        uiState = uiState,
        keyboardController = keyboardController,
        onSearchFieldChanged = viewModel::updateSearchValue,
        onEnterClicked = viewModel::loadMovieList,
        onClickMovieItem = viewModel::navigateToDetail
    )
}

@Composable
fun HomeScreen(
    uiState: HomeState = HomeState(),
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    onSearchFieldChanged: (String) -> Unit = {},
    onEnterClicked: (String) -> Unit = {},
    onClickMovieItem: (String) -> Unit = {},
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        GocafeinSearchBar(
            value = uiState.searchValue,
            keyboardController = keyboardController,
            onValueChanged = onSearchFieldChanged,
            onEnterClicked = onEnterClicked,
        )
        LazyColumn {
            items(items = uiState.movieList) { content ->
                MovieItem(
                    posterImage = content.Poster,
                    title = content.Title,
                    openDate = content.Year,
                    id = content.imdbID,
                    onClick = onClickMovieItem,
                )
            }
        }
    }
}

@Preview(apiLevel = 33, showBackground = false)
@Composable
fun HomePreview() {
    HomeScreen()
}