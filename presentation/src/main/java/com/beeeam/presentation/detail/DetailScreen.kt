package com.beeeam.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.beeeam.presentation.R
import com.beeeam.presentation.detail.component.RatingItem
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(12.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            GlideImage(
                model = uiState.movieDetail.Poster,
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
                    text = uiState.movieDetail.Title,
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "(${uiState.movieDetail.Released})",
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = uiState.movieDetail.Runtime,
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.Bold
                )
                RatingItem(
                    ic = R.drawable.ic_imdb_logo,
                    rate = if (uiState.movieDetail.Ratings.isEmpty()) ""
                            else uiState.movieDetail.Ratings[0].Value
                )
                RatingItem(
                    ic = R.drawable.ic_rotten_tomatoes_logo,
                    rate = if (uiState.movieDetail.Ratings.isEmpty()) ""
                            else uiState.movieDetail.Ratings[1].Value
                )
                RatingItem(
                    ic = R.drawable.ic_metacritic_logo,
                    rate = if (uiState.movieDetail.Ratings.isEmpty()) ""
                            else uiState.movieDetail.Ratings[2].Value
                )
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
                text = uiState.movieDetail.Plot,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

@Preview(apiLevel = 33)
@Composable
fun DetailPreview() {
    DetailScreen()
}