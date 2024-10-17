package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun MorePeopleNumber(number: Int) {
    Box(
        modifier = Modifier
            .size(47.dp)
            .border(width = 2.dp, color = PartyAppTheme.colors.newWhiteColor, shape = CircleShape)
            .clip(CircleShape)
            .background(color = PartyAppTheme.colors.notSelectedColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "+ $number",
            style = PartyAppTheme.typography.secondary,
            color = PartyAppTheme.colors.newMainColor
        )
    }
}