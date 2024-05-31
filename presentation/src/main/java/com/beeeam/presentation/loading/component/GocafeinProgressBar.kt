package com.beeeam.presentation.loading.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GocafeinProgressBar(
    modifier: Modifier = Modifier
){
    LinearProgressIndicator(
        modifier = modifier
            .height(10.dp),
        trackColor = Color.Black,
        color = Color.Red
    )
}

@Preview(apiLevel = 33)
@Composable
fun GocafeinProgressPreview() {
    GocafeinProgressBar()
}