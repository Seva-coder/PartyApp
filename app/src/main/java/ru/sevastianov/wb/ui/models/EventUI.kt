package ru.sevastianov.wb.ui.models

data class EventUI(
    var title: String,
    val date: Int,
    val place: String,
    val tags: List<String>,
    val imageUrl: String,
    val isEnded: Boolean
)
