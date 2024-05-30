package com.beeeam.presentation.detail.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.beeeam.presentation.R

@Composable
fun BackBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Icon(
        modifier = modifier.clickable { onClick() },
        painter = painterResource(id = R.drawable.ic_back_btn),
        contentDescription = "",
        tint = Color.LightGray,
    )
}