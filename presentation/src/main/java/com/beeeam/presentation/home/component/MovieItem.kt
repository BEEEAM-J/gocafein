package com.beeeam.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.DarkGray)
            .clickable { onClick(id) }
    ) {
        GlideImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            model = posterImage,
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(alignment = Alignment.CenterHorizontally),
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(alignment = Alignment.CenterHorizontally),
            text = openDate,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(apiLevel = 33, backgroundColor = 0xFF000000, showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieItem(
        title = "Test Title",
        openDate = "2024.05.28",
    )
}