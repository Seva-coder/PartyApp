package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.models.EventsListState


@Composable
internal fun EventsListMainPart(
    screenState: EventsListState,
    searchFilter: (String) -> Unit,
    setNewTags: (Set<Long>) -> Unit,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 0.dp)
    ) {
        item {
            SearchBlock(
                modifier = Modifier
                    .fillMaxWidth(),
                onTextChange = searchFilter
            )
        }

        if (!screenState.searchingActive) {
            item {
                EventsScroller(
                    modifier = Modifier
                        .fillMaxWidth(),
                    cardType = CardType.Big,
                    events = screenState.bigEvents
                ) { eventId ->
                    navController.navigate(route = Screen.EventDetailScr(eventId = eventId)) {
                        launchSingleTop = true
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(40.dp))
                LabelCustom(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.nearest_events)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                EventsScroller(
                    modifier = Modifier
                        .fillMaxWidth(),
                    cardType = CardType.Thin,
                    events = screenState.nearestEvents
                ) { eventId ->
                    navController.navigate(route = Screen.EventDetailScr(eventId = eventId)) {
                        launchSingleTop = true
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                LabelCustom(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = stringResource(R.string.other_events)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TagsPicker(
                    tagsList = screenState.allTags,
                    updateTags = { newTags -> setNewTags(newTags) },
                    enabledTags = screenState.enabledTags,
                    size = TagSize.Medium
                )
            }
        }

        items(screenState.mainEventsList.take(3)) { card ->
            Spacer(modifier = Modifier.height(16.dp))
            EventCard(
                imageUrl = card.imageUrl,
                name = card.name,
                date = card.date,
                place = card.place,
                tags = card.tags,
                type = CardType.Full,
                id = card.id,
                onClick = { eventId ->
                    navController.navigate(route = Screen.EventDetailScr(eventId = eventId)) {
                        launchSingleTop = true
                    }
                }
            )
        }

        if (!screenState.interestsExist) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                SelectInterests(modifier = Modifier.fillMaxWidth(), onClick = { })
            }
        }

        items(screenState.mainEventsList.drop(3)) { card ->
            Spacer(modifier = Modifier.height(16.dp))
            EventCard(
                imageUrl = card.imageUrl,
                name = card.name,
                date = card.date,
                place = card.place,
                tags = card.tags,
                type = CardType.Full,
                id = card.id,
                onClick = { eventId ->
                    navController.navigate(route = Screen.EventDetailScr(eventId = eventId)) {
                        launchSingleTop = true
                    }
                }
            )
        }

    }
}