package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ru.sevastianov.wb.R
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider

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
            EventCard(imageId = meeting.imageId, title = meeting.name, dateWithPlace = meeting.place, tags = meeting.tags, isEnded = false)
            if (index < list.lastIndex) {
                HorizontalDivider()
            }
        }
    }
}

data class Meeting(val name: String, val place: String, val imageId: Int, val tags: List<String>)