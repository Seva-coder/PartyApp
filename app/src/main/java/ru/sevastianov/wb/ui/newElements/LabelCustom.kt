package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
internal fun LabelCustom(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            style = PartyAppTheme.typography.H2,
            color = PartyAppTheme.colors.newDarkColor
        )
    }
}