package com.beeeam.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beeeam.presentation.home.component.GocafeinSearchBar
import com.beeeam.presentation.home.component.MovieItem
import com.beeeam.presentation.loading.LoadingScreen
import com.beeeam.presentation.util.OnBottomReached
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun HomeRoute(
    onShowToast: (String) -> Unit = {},
    navigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val movieListState = rememberLazyGridState()
    val uiState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is HomeSideEffect.NavigateToDetail -> navigateToDetail(sideEffect.id)
            is HomeSideEffect.ShowToastManyResult -> onShowToast("검색 결과가 너무 많습니다! 다른 검색어를 사용해주세요.")
            is HomeSideEffect.ShowToastNotFound -> onShowToast("검색 결과가 없습니다!")
        }
    }

    movieListState.OnBottomReached {
        viewModel.loadMovieList(false)
    }

    HomeScreen(
        uiState = uiState,
        movieListState = movieListState,
        keyboardController = keyboardController,
        onSearchFieldChanged = viewModel::updateSearchValue,
        onEnterClicked = viewModel::search,
        onClickClearBtn = { viewModel.updateSearchValue("") },
        onClickMovieItem = viewModel::navigateToDetail
    )
}

@Composable
fun HomeScreen(
    uiState: HomeState = HomeState(),
    movieListState: LazyGridState = rememberLazyGridState(),
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    onSearchFieldChanged: (String) -> Unit = {},
    onEnterClicked: () -> Unit = {},
    onClickClearBtn: () -> Unit = {},
    onClickMovieItem: (String) -> Unit = {},
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(18.dp)
    ) {
        GocafeinSearchBar(
            value = uiState.searchValue,
            keyboardController = keyboardController,
            onValueChanged = onSearchFieldChanged,
            onEnterClicked = onEnterClicked,
            onClearBtnClicked = onClickClearBtn,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(vertical = 24.dp),
            state = movieListState,
        ) {
            items(items = uiState.movieList, key = { it.movieId }) { content ->
                MovieItem(
                    posterImage = content.poster,
                    title = content.title,
                    openDate = content.year,
                    id = content.movieId,
                    onClick = onClickMovieItem,
                )
            }
        }
    }

    if(uiState.isLoading){
        LoadingScreen()
    }
}

@Preview(apiLevel = 33, showBackground = false)
@Composable
fun HomePreview() {
    HomeScreen()
}