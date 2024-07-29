package ru.sevastianov.repository

import android.content.Context
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetails
import ru.sevastianov.domain.repository.IEventsRepository
import kotlinx.coroutines.flow.Flow


internal class EventsRepository(val context: Context) : IEventsRepository {
    override fun getActiveEvents(): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun getAllEvents(): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun getEventDetails(eventId: Long): Flow<EventDetails> {
        TODO("Not yet implemented")
    }

    override fun getOldEvents(): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun getPlannedEvents(): Flow<List<Event>> {
        TODO("Not yet implemented")
    }

    override fun setGoToEvent(goingToEvent: Boolean, eventId: Long) {
        TODO("Not yet implemented")
    }


}