package com.beeeam.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val uiState = viewModel.collectAsState().value

    LaunchedEffect(key1 = Unit) { viewModel.loadMovieDetail() }

    DetailScreen(
        uiState = uiState,
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    uiState: DetailState = DetailState()
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        GlideImage(
            model = uiState.movieDetail.Poster,
            contentDescription = ""
        )
        Text(text = "Title: ${uiState.movieDetail.Title}")
        Text(text = "Released: ${uiState.movieDetail.Released}")
        Text(text = "rate: ${uiState.movieDetail.Ratings}")
        Text(text = "plot: ${uiState.movieDetail.Plot}")
    }
}

@Preview(apiLevel = 33)
@Composable
fun DetailPreview() {
    DetailScreen()
}