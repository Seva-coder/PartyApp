package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.flow.StateFlow
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.models.EventCardUI
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
internal fun EventsList(eventsListFlow: StateFlow<List<EventCardUI>>, navController: NavController) {
    val eventsList = eventsListFlow.collectAsStateWithLifecycle().value
    LazyColumn(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
    ) {
        itemsIndexed(eventsList) { index, event ->
            Spacer(modifier = Modifier.height(8.dp))
            EventCard(imageUrl = event.imageUrl,
                title = event.name,
                dateWithPlace = "${event.place} - ${event.date}",
                tags = event.tags,
                isEnded = false,
                eventId = index.toLong()
            ) { eventIdClicked ->
                navController.navigate(Screen.EventDetailScr(eventId = eventIdClicked)) {
                    launchSingleTop = true
                }
            }
            if (index < eventsList.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = PartyAppTheme.colors.dividerColor)
            }
        }
    }
}