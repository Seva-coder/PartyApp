package ru.sevastianov.wb.ui.models

internal data class EventsListState(
    val bigEvents: List<EventCardUI>,
    val nearestEvents: List<EventCardUI>,
    val allTags: List<TagUI>,
    val searchingActive: Boolean,
    val enabledTags: Set<Long>,
    val mainEventsList: List<EventCardUI>,
    val interestsExist: Boolean
)
