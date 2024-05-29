package com.beeeam.presentation.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.beeeam.presentation.R

@Composable
fun TextFieldClearBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Icon(
        modifier = modifier
            .clip(CircleShape)
            .clickable (onClick = onClick),
        painter = painterResource(id = R.drawable.ic_btn_clear),
        tint = Color.White,
        contentDescription = "",
    )
}