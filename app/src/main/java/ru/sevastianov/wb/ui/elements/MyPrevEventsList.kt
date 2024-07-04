package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import ru.sevastianov.wb.R

@Composable
fun MyPrevEventsList() {
    val meeting = Meeting(
        name = "Developer meeting",
        place = "13.09.2024 - Москва",
        imageId = R.drawable.ava_main,
        tags = listOf("Python", "Junior", "Moscow")
    )
    val list = List(5) { meeting }
    Column {
        LazyColumn {
            itemsIndexed(list) { index, meeting ->
                EventCard(imageId = meeting.imageId, title = meeting.name, dateWithPlace = meeting.place, tags = meeting.tags, isEnded = true)
                if (index < list.lastIndex) {
                    HorizontalDivider()
                }
            }
        }
    }
}