package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetails


interface IEventsRepository {

    fun getActiveEvents(): Flow<List<Event>>
    fun getAllEvents(): Flow<List<Event>>
    fun getEventDetails(eventId: Long): Flow<EventDetails>
    fun getOldEvents(): Flow<List<Event>>
    fun getPlannedEvents(): Flow<List<Event>>
    fun setGoToEvent(goingToEvent: Boolean, eventId: Long)

}