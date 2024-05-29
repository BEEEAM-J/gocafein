package com.beeeam.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(
    posterImage: String = "",
    title: String = "",
    openDate: String = "",
    id: String = "",
    onClick: (String) -> Unit = {},
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(id) }
    ) {
        GlideImage(
            model = posterImage,
            contentDescription = ""
        )
        Column {
            Text(text = title)
            Text(text = openDate)
        }
    }
}

@Preview(apiLevel = 33)
@Composable
fun MovieItemPreview() {
    MovieItem(
        title = "Test Title",
        openDate = "2024.05.28",
    )
}