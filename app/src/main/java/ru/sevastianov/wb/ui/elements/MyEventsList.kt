package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ru.sevastianov.wb.R
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun MyEventsList() {
    val meeting = Meeting(
        name = "Developer meeting",
        place = "13.09.2024 - Москва",
        imageId = R.drawable.ava_main,
        tags = listOf("Python", "Junior", "Moscow")
    )
    val list = List(5) { meeting }
    LazyColumn {
        itemsIndexed(list) { index, meeting ->
            Spacer(modifier = Modifier.height(20.dp))
            EventCard(imageId = meeting.imageId, title = meeting.name, dateWithPlace = meeting.place, tags = meeting.tags, isEnded = false)
            if (index < list.lastIndex) {
                Spacer(modifier = Modifier.height(20.dp))
                HorizontalDivider(color = PartyAppTheme.colors.dividerColor)
            }
        }
    }
}

data class Meeting(val name: String, val place: String, val imageId: Int, val tags: List<String>)