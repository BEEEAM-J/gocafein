package com.beeeam.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beeeam.presentation.R

@Composable
fun GocafeinSearchBar(
    value: String = "",
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    onValueChanged: (String) -> Unit = {},
    onEnterClicked: (String) -> Unit = {},
    onClearBtnClicked: () -> Unit = {},
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(color = Color.White),
        cursorBrush = SolidColor(Color.White),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                if (!value.isNullOrEmpty()) {
                    onEnterClicked(value)
                    keyboardController?.hide()
                }
            }
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.DarkGray, shape = RoundedCornerShape(size = 10.dp))
                    .padding(all = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "",
                    tint = Color.White,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(modifier = Modifier.weight(1f)) {
                    innerTextField()
                    if (value.isEmpty()) {
                        Text(
                            text = "검색어를 입력해주세요",
                            color = Color.LightGray,
                        )
                    }
                }
                Spacer(modifier = Modifier.width(8.dp))
                TextFieldClearBtn(onClick = onClearBtnClicked)
            }
        },
    )
}

@Preview(apiLevel = 33)
@Composable
fun SearchBarPreview() {
    GocafeinSearchBar()
}