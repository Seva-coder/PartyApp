package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.extensions.conditional
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun InputCustom(
    modifier: Modifier = Modifier,
    placeHolderText: String = "",
    state: InputState = InputState.Normal,
    icon: IconType = IconType.None,
    onChange: (String) -> Unit = {}
) {

    var showHint by rememberSaveable { mutableStateOf(true) }
    var focused by rememberSaveable { mutableStateOf(false) }
    var text by rememberSaveable { mutableStateOf("") }

    BasicTextField(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .onFocusChanged { newFocusState ->
                showHint = (text.isEmpty() && !newFocusState.isFocused)
                focused = newFocusState.isFocused
            }
            .conditional(state == InputState.Error, {
                background(color = PartyAppTheme.colors.errorColor)
            }, {
                background(color = PartyAppTheme.colors.newWhiteColor)
            }),

        value = text,
        onValueChange = { newString ->
            text = newString
            onChange(newString)
        },
        textStyle = PartyAppTheme.typography.regular,
        cursorBrush = SolidColor(PartyAppTheme.colors.newDarkColor),
        decorationBox = { inputField ->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .conditional(focused, {
                        border(
                            width = 1.dp,
                            color = PartyAppTheme.colors.initialColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                    })
                    .padding(horizontal = 12.dp, vertical = 16.dp)
            ) {
                val iconId = when (icon) {
                    IconType.None -> null
                    IconType.Habr -> R.drawable.habr
                    IconType.Telegram -> R.drawable.telegram
                }

                val placeHolder = when (icon) {
                    IconType.None -> placeHolderText
                    IconType.Habr -> stringResource(R.string.habr_hint)
                    IconType.Telegram -> stringResource(R.string.telegram_hint)
                }

                iconId?.let { id ->
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = id),
                        contentDescription = "icon",
                        tint = PartyAppTheme.colors.greyTextColor2
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                }

                if (showHint) {
                    Text(
                        text = placeHolder,
                        style = PartyAppTheme.typography.regular,
                        color = PartyAppTheme.colors.greyTextColor2
                    )
                } else {
                    inputField()
                }
            }
        }
    )
}

enum class InputState {
    Normal,
    Error
}

enum class IconType {
    None,
    Habr,
    Telegram
}