package com.beeeam.presentation.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beeeam.domain.model.Rating

@Composable
fun RatingItem(
    modifier: Modifier = Modifier,
    rating: Rating
) {
    Column(
        modifier = modifier.padding(vertical = 4.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = rating.Source,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = rating.Value,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Preview(apiLevel = 33, showSystemUi = true)
@Composable
fun RatingItemPreview() {
    RatingItem(rating = Rating("rotten tomato", "40%"))
}