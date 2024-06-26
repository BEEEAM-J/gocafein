package com.beeeam.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beeeam.presentation.detail.component.BackBtn
import com.beeeam.presentation.detail.component.RatingItem
import com.beeeam.presentation.loading.LoadingScreen
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel(),
    popBackStack: () -> Unit = {},
) {
    val uiState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is DetailSideEffect.PopBackStack -> popBackStack()
        }
    }

    LaunchedEffect(key1 = Unit) { viewModel.loadMovieDetail() }

    DetailScreen(
        uiState = uiState,
        popBackStack = viewModel::popBackStack
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    uiState: DetailState = DetailState(),
    popBackStack: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(12.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            BackBtn(
                modifier = Modifier.align(Alignment.CenterStart),
                onClick = popBackStack,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            GlideImage(
                model = uiState.movieDetail.poster,
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(start = 24.dp)
            ) {
                Text(
                    text = uiState.movieDetail.title,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(${uiState.movieDetail.released})",
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = uiState.movieDetail.runtime,
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
                uiState.movieDetail.ratings.forEach {
                    RatingItem(
                        rating = it
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.DarkGray)
                    .padding(18.dp),
                text = uiState.movieDetail.plot,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )
        }
        if (uiState.isLoading) {
            LoadingScreen()
        }
    }
}

@Preview(apiLevel = 33)
@Composable
fun DetailPreview() {
    DetailScreen()
}