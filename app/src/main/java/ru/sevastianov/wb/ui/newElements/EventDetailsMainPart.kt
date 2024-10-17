package ru.sevastianov.wb.ui.newElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.extensions.conditional
import ru.sevastianov.wb.ui.models.EventDetailsState
import ru.sevastianov.wb.ui.theme.PartyAppTheme


@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventDetailsMainPart(
    eventId: Long,
    screenState: EventDetailsState,
    enableBottomPadding: Boolean,
    bottomPaddingDp: Dp = 0.dp,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .conditional(enableBottomPadding, ifTrue = {
                padding(bottom = bottomPaddingDp)
            })
    ) {
        item {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(267.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(PartyAppTheme.colors.background),
                model = screenState.eventImageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
        }

        item {
            Text(
                text = screenState.eventName,
                style = PartyAppTheme.typography.H1,
                color = PartyAppTheme.colors.newDarkColor
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${screenState.dateStr} · ${screenState.place}",
                style = PartyAppTheme.typography.secondary,
                color = PartyAppTheme.colors.newGreyColor
            )
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            FlowRow {
                screenState.tagsList.forEach { tagText ->
                    Box(modifier = Modifier.padding(8.dp)) {
                        Tag(name = tagText, size = TagSize.Small)
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = screenState.eventDescription,
                style = PartyAppTheme.typography.secondary,
                color = PartyAppTheme.colors.newDarkColor
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            OrganizerCard(
                modifier = Modifier
                    .fillMaxWidth(),
                title = stringResource(R.string.speaker),
                name = screenState.speakerName,
                text = screenState.speakerDescription,
                imageUrl = screenState.speakerImageUrl,
                subscribed = false
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            Location(
                modifier = Modifier.fillMaxWidth(),
                address = screenState.place,
                metro = screenState.metroName,
                lat = screenState.lat,
                lon = screenState.lon
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            LabelCustom(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.are_going_to_event)
            )
            Spacer(modifier = Modifier.height(15.dp))
            AvatarsList(
                urls = screenState.avatarsList,
                maxNumber = 2,
                onClick = {
                    navController.navigate(Screen.UsersListScreen(eventId = eventId))
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            OrganizerCard(
                modifier = Modifier
                    .fillMaxWidth(),
                title = stringResource(R.string.organizer_label),
                name = screenState.organizerName,
                text = screenState.organizerDescription,
                imageUrl = screenState.organizerImageUrl,
                subscribed = screenState.subscribedToGroup
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            LabelCustom(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.other_events_of_group)
            )
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            EventsScroller(
                modifier = Modifier.fillMaxWidth(),
                cardType = CardType.Thin,
                events = screenState.sameEvents
            ) { eventId ->
                navController.navigate(route = Screen.EventDetailScr(eventId = eventId)) {
                    popUpTo(navController.currentDestination?.route ?: "") {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        }

    }
}