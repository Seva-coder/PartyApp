package ru.sevastianov.wb.ui.models


internal data class EventDetailsUI(
    val eventId: Long,
    val logoUrl: String,
    val name: String,
    val dateInt: Int,
    val dateStr: String,
    val place: String,
    val metroName: String,
    val description: String,
    val lat: Double,
    val lon: Double,
    val speakerName: String,
    val speakerDescription: String,
    val speakerImg: String,
    val freeSpaces: Int,
    val tags: List<String>
)
