package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.models.EventCardUI


@Composable
internal fun EventsScroller(
    modifier: Modifier = Modifier,
    events: List<EventCardUI>,
    cardType: CardType = CardType.Big,
    cardClick: (Long) -> Unit = { }
) {
    Column(modifier = modifier) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(events.size) { index ->
                val card = events[index]
                EventCard(
                    imageUrl = card.imageUrl,
                    name = card.name,
                    date = card.date,
                    place = card.place,
                    tags = card.tags,
                    type = cardType,
                    id = card.id,
                    onClick = cardClick
                )
            }
        }
    }
}