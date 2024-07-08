package ru.sevastianov.wb.ui.elements


import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun EventCard(imageUrl: String, title: String, dateWithPlace: String, tags: List<String>, isEnded: Boolean,
              eventId: Long, onClick: (Long) -> Unit) {

    val scrollState = rememberScrollState()

    Row(modifier = Modifier.clickable { onClick(eventId) }) {
        Column(modifier = Modifier
            .padding(end = 10.dp)
        ) {
            EventAvatar(imageUrl)
        }

        Column {
            Box(modifier = Modifier
                .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = PartyAppTheme.typography.bodyText1,
                    color = PartyAppTheme.colors.darkTextColor
                )
                if (isEnded) {
                    Text(text = "Закончилась",
                        style = PartyAppTheme.typography.metadata2,
                        color = PartyAppTheme.colors.greyTextColor,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                    )
                }
            }

            Text(text = dateWithPlace,
                style = PartyAppTheme.typography.metadata1,
                color = PartyAppTheme.colors.greyTextColor
            )
            Row(
                Modifier.horizontalScroll(scrollState)
            ) {
                tags.forEach {
                    Chip(it)
                }
            }
        }
    }

}
