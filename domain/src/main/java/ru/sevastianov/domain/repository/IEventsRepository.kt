package ru.sevastianov.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetailsDomain


interface IEventsRepository {

    fun getActiveEvents(): Flow<List<Event>>
    fun getOldEvents(): Flow<List<Event>>
    fun getPlannedEvents(): Flow<List<Event>>
    fun setGoToEvent(goingToEvent: Boolean, eventId: Long)

    //
    fun getAllBigEvents(): Flow<List<Event>>
    fun getNearestEventsFlow(afterTime: Int): Flow<List<Event>>
    fun getAllEvents(): Flow<List<Event>>
    fun getAllEventsByTagId(idSet: Set<Long>): Flow<List<Event>>
    fun getEventsByText(textFilter: String): Flow<List<Event>>
    fun getEventDetails(eventId: Long): Flow<EventDetailsDomain>
    fun setSubscribeToEvent(eventId: Long, setSubscribed: Boolean)
    fun getEventSubscription(eventId: Long): Flow<Boolean>
    fun getGroupEventsByEventId(eventId: Long): Flow<List<Event>>

}