package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ru.sevastianov.wb.R
import androidx.compose.foundation.lazy.items

@Composable
fun MyEventsList() {
    val list = listOf(
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow")),
        Meeting(name = "Developer meeting", place = "13.09.2024 - Москва", imageId = R.drawable.ava_main, tags = listOf("Python", "Junior", "Moscow"))
    )
    LazyColumn {
        items(list) { meeting ->
            EventCard(imageId = meeting.imageId, title = meeting.name, dateWithPlace = meeting.place, tags = meeting.tags, isEnded = false)
        }
    }
}

data class Meeting(val name: String, val place: String, val imageId: Int, val tags: List<String>)