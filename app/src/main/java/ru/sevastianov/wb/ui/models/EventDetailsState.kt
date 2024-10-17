package ru.sevastianov.wb.ui.models

import ru.sevastianov.wb.ui.newElements.SubscribeState


internal data class EventDetailsState(
    val eventName: String,
    val eventImageUrl: String,
    val dateUnix: Int,
    val dateStr: String,
    val place: String,
    val tagsList: List<String>,
    val eventDescription: String,
    val speakerName: String,
    val speakerDescription: String,
    val speakerImageUrl: String,
    val metroName: String,
    val avatarsList: List<String>,
    val organizerName: String,
    val organizerDescription: String,
    val organizerImageUrl: String,
    val subscribedToGroup: Boolean,
    val sameEvents: List<EventCardUI>,
    val freeSpaces: Int,
    val subscription: SubscribeState,
    val lat: Double,
    val lon: Double
)
