package ru.sevastianov.domain.models

data class Event(
    var title: String,
    val date: Int,
    val place: String,
    val tags: List<String>,
    val imageUrl: String,
    val isEnded: Boolean
)