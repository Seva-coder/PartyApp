package ru.sevastianov.wb.ui.screens


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.sevastianov.wb.R
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.elements.EventCard
import ru.sevastianov.wb.ui.elements.Meeting
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun GroupDetailScreen(groupId: Long, navController: NavController) {

    val meeting = Meeting(
        name = "Developer meeting",
        place = "13.09.2024 - Москва",
        imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
        tags = listOf("Python", "Junior", "Moscow")
    )
    val list = List(5) { meeting }

    val text = LoremIpsum(100).values.joinToString(separator = " ")

    LazyColumn(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = text,
                style = PartyAppTheme.typography.metadata1,
                color = PartyAppTheme.colors.greyTextColor
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.events_of_group_text),
                style = PartyAppTheme.typography.bodyText1,
                color = PartyAppTheme.colors.greyTextColor
            )
        }

        itemsIndexed(list) { index, meeting ->
            Spacer(modifier = Modifier.height(8.dp))
            EventCard(
                imageUrl = meeting.imageUrl,
                title = meeting.name,
                dateWithPlace = meeting.place,
                tags = meeting.tags,
                isEnded = false,
                eventId = index.toLong()
            ) { eventIdClicked ->
                navController.navigate(Screen.EventDetailScr(eventId = eventIdClicked)) {
                    launchSingleTop = true
                }
            }
            if (index < list.lastIndex) {
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = PartyAppTheme.colors.dividerColor)
            }
        }

    }

}