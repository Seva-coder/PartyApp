package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@Composable
fun TypographyRow(title: String, subTitle: String, text: String, style: TextStyle) {

    Row(modifier = Modifier
        .padding(horizontal = 10.dp, vertical = 10.dp)
        .fillMaxWidth()
    ) {
        Column(modifier = Modifier
            .width(150.dp)
        ) {
            Text(text = title,
                style = PartyAppTheme.typography.subheading1,
                color = PartyAppTheme.colors.darkTextColor
            )
            Text(text = subTitle,
                style = PartyAppTheme.typography.bodyText2,
                color = PartyAppTheme.colors.greyTextColor2)
        }
        LazyRow {
            item {
                Text(text = text,
                    style = style,
                    color = PartyAppTheme.colors.darkTextColor
                )
            }
        }
    }
}