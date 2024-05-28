package com.beeeam.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beeeam.search.component.GocafeinSearchBar
import com.beeeam.search.component.MovieItem
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

val itemList = listOf(SampleData(), SampleData(), SampleData())

@Composable
fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val uiState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->

    }
    SearchScreen(
        uiState = uiState,
        onSearchFieldChanged = viewModel::updateSearchValue
    )
}

@Composable
fun SearchScreen(
    uiState: SearchState = SearchState(),
    onSearchFieldChanged: (String) -> Unit = {},
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        GocafeinSearchBar(
            value = uiState.searchValue,
            onValueChanged = onSearchFieldChanged,
        )
        LazyColumn {
            items(items = itemList) { content ->
                MovieItem(
                    posterImage = content.posterImage,
                    title = content.title,
                    openDate = content.openDate,
                    rate = content.rate,
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