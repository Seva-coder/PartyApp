package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun Search(
    onSearch: (state: TextFieldState) -> Unit
) {
    val state = rememberTextFieldState("")

    BasicTextField(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 6.dp)
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(color = PartyAppTheme.colors.neutralWhite),

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        lineLimits = TextFieldLineLimits.SingleLine,
        textStyle = PartyAppTheme.typography.bodyText1.copy(color = PartyAppTheme.colors.darkTextColor),
        state = state,

        decorator = { inputField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .size(24.dp),
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search Icon",
                    tint = PartyAppTheme.colors.greyTextColor2
                )

                Box(modifier = Modifier
                    .align(Alignment.CenterVertically)
                ) {
                    if (state.text.isEmpty()) {
                        Text(text = "Поиск",
                            style = PartyAppTheme.typography.bodyText1,
                            color = PartyAppTheme.colors.greyTextColor2,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                    inputField()
                }

            }
        }
    )

}