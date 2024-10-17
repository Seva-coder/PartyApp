package ru.sevastianov.wb.ui.models

internal data class EventCardUI(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val date: String,
    val place: String,
    val tags: List<String>,
)
