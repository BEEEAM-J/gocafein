package com.beeeam.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.beeeam.presentation.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val uiState = viewModel.collectAsState().value

    DetailScreen()
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
//        GlideImage(
//            model = R.drawable.sample_image,
//            contentDescription = ""
//        )
        Image(
            painter = painterResource(id = R.drawable.sample_image),
            contentDescription = "",
        )
        Text(text = "Title: Test Title")
        Text(text = "Released: 29 May 2024")
        Text(text = "rate: 10/10")
        Text(text = "plot: Luke Skywalker joins forces with a Jedi Knight...")
    }
}

@Preview(apiLevel = 33)
@Composable
fun DetailPreview() {
    DetailScreen()
}