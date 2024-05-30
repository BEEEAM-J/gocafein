package com.beeeam.presentation.detail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun RatingItem(
    modifier: Modifier = Modifier,
    ic: Int,
    rate: String,
) {
    Row(
        modifier = modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier
                .weight(0.3f)
                .size(32.dp),
            painter = painterResource(id = ic),
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.weight(0.7f),
            text = rate,
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(apiLevel = 33)
@Composable
fun RatingItemPreview() {
    RatingItem(ic = 0, rate = "")
}