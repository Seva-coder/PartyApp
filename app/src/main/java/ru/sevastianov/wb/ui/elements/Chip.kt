package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun Chip(text: String) {
    SuggestionChip(
        onClick = {  },
        label = {
            Text(text = text,
            style = PartyAppTheme.typography.metadata3,
            color = PartyAppTheme.colors.hoverColor
        ) },
        shape = RoundedCornerShape(40.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = PartyAppTheme.colors.borderColor,
            labelColor = PartyAppTheme.colors.hoverColor
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderColor = PartyAppTheme.colors.borderColor
        ),
        modifier = Modifier
            .padding(horizontal = 2.dp, vertical = 8.dp),

    )
}