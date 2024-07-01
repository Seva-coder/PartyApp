package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import ru.sevastianov.wb.R

@Composable
fun MyPrevEventsList() {
    val list = listOf(
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow"))
    )
    Column {
        LazyColumn {
            items(list) { meeting ->
                EventCard(imageId = meeting.imageId, title = meeting.name, dateWithPlace = meeting.place, tags = meeting.tags, isEnded = true)
            }
        }
    }
}