package com.beeeam.search

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
import com.beeeam.search.component.GocafeinSearchBar
import com.beeeam.search.component.MovieItem
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val uiState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->

    }

    LaunchedEffect(key1 = Unit) {
        viewModel.loadMovieList("star")
    }

    SearchScreen(
        uiState = uiState,
        keyboardController = keyboardController,
        onSearchFieldChanged = viewModel::updateSearchValue,
        onEnterClicked = viewModel::loadMovieList,
        /*onClickMovieItem =*/
    )
}

@Composable
fun SearchScreen(
    uiState: SearchState = SearchState(),
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
fun SearchPreview() {
    SearchScreen()
}