package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.sevastianov.wb.Screen
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun MyEventsList(navController: NavController) {
    val meeting = Meeting(
        name = "Developer meeting",
        place = "13.09.2024 - Москва",
        imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
        tags = listOf("Python", "Junior", "Moscow")
    )
    val list = List(5) { meeting }
    LazyColumn(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
    ) {
        itemsIndexed(list) { index, meeting ->
            Spacer(modifier = Modifier.height(8.dp))
            EventCard(imageUrl = meeting.imageUrl,
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

data class Meeting(val name: String, val place: String, val imageUrl: String, val tags: List<String>)