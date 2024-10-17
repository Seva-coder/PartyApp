package ru.sevastianov.domain.models


data class EventDetailsDomain(
    val eventId: Long,
    val logoUrl: String,
    val name: String,
    val dateUnix: Int,
    val place: String,
    val metroName: String,
    val description: String,
    val iGo: Boolean,
    val lat: Double,
    val lon: Double,
    val speakerName: String,
    val speakerDescription: String,
    val speakerImg: String,
    val freeSpaces: Int,
    val tags: List<String>
)