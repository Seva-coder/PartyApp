package ru.sevastianov.domain.models


data class Event(
    val eventId: Long,
    val title: String,
    val imageUrl: String,
    val date: Int,
    val place: String,
    val tags: List<String>,
)