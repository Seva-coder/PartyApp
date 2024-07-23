package ru.sevastianov.domain.models


data class EventDetails(
    val chips: List<String>,
    val date: Int,
    val place: String,
    val description: String,
    val coordinates: Coordinates,
    val participants: List<Participant>,
    val iGoing: Boolean
)