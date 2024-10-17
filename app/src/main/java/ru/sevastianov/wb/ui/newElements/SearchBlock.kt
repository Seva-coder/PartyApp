package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.R
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun SearchBlock(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = { },
    onUserIconClick: () -> Unit = { }
) {
    val focusManager = LocalFocusManager.current

    var text by rememberSaveable { mutableStateOf("") }
    var showHint by rememberSaveable { mutableStateOf(true) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(16.dp))
            .onFocusChanged { newFocusState ->
                showHint = (text.isEmpty() && !newFocusState.isFocused)
            }
            .background(color = PartyAppTheme.colors.notSelectedColor),
            value = text,
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            onValueChange = { newText ->
                text = newText
                onTextChange(newText)
            },
            decorationBox = { innerField ->
                Row(
                    modifier = Modifier
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    if (showHint) {
                        Icon(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .size(24.dp),
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search Icon",
                            tint = PartyAppTheme.colors.greyTextColor
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(vertical = 13.dp, horizontal = 6.dp)
                    ) {
                        if (showHint) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterStart),
                                text = stringResource(R.string.find_events_hint),
                                style = PartyAppTheme.typography.secondary,
                                color = PartyAppTheme.colors.newGreyColor
                            )
                        }
                        innerField()
                    }

                    if (!showHint) {
                        Icon(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .clickable {
                                    text = ""
                                    onTextChange(text)
                                },
                            painter = painterResource(id = R.drawable.cross),
                            contentDescription = "Close icon",
                            tint = PartyAppTheme.colors.newGreyColor
                        )
                    }
                }
            }
        )

        if (showHint) {
            Icon(
                modifier = Modifier
                    .clickable { onUserIconClick() },
                painter = painterResource(id = R.drawable.user),
                tint = PartyAppTheme.colors.newMainColor,
                contentDescription = "account"
            )
        } else {
            Text(modifier = Modifier
                .clickable {
                    text = ""
                    onTextChange(text)
                    focusManager.clearFocus()
                }
                .padding(horizontal = 5.dp),
                text = stringResource(R.string.cancel),
                style = PartyAppTheme.typography.H4,
                color = PartyAppTheme.colors.newMainColor
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }

}
