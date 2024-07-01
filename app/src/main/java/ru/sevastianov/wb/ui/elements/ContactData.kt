package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun ContactData(name: String, phone: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            style = PartyAppTheme.typography.heading2,
            color = PartyAppTheme.colors.darkTextColor
        )
        Text(
            text = phone,
            style = PartyAppTheme.typography.subheading2,
            color = PartyAppTheme.colors.greyTextColor2
        )
    }
}