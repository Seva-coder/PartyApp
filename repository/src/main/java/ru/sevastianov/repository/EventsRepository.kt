package ru.sevastianov.repository

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetailsDomain
import ru.sevastianov.domain.repository.IEventsRepository
import ru.sevastianov.repository.dao.EventDao


internal class EventsRepository(
    val context: Context,
    val eventDao: EventDao,
    val converter: Entity2Domain
) : IEventsRepository {
    override fun getActiveEvents(): Flow<List<Event>> {
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

    ////////

    override fun getAllBigEvents(): Flow<List<Event>> {
        val entitiesFlow = eventDao.getAllBigEvents()

        val domainFlow = entitiesFlow.map {
            it.map { event -> converter.event2domain(event) }
        }

        return domainFlow
    }

    override fun getNearestEventsFlow(afterTime: Int): Flow<List<Event>> {
        val entitiesFlow = eventDao.getNearestEvents(afterTime)

        val domainFlow = entitiesFlow.map {
            it.map { event -> converter.event2domain(event) }
        }

        return domainFlow
    }

    override fun getAllEvents(): Flow<List<Event>> {
        val entitiesFlow = eventDao.getAllEvents()

        val domainFlow = entitiesFlow.map {
            it.map { event -> converter.event2domain(event) }
        }

        return domainFlow
    }

    override fun getAllEventsByTagId(idSet: Set<Long>): Flow<List<Event>> {
        val entitiesFlow = eventDao.getAllEventsByTagIds(idSet.toList())

        val domainFlow = entitiesFlow.map {
            it.map { event -> converter.event2domain(event) }
        }

        return domainFlow
    }

    override fun getEventsByText(textFilter: String): Flow<List<Event>> {
        val entitiesFlow = eventDao.getEventsFiltredByText("%${textFilter}%")

        val domainFlow = entitiesFlow.map {
            it.map { event -> converter.event2domain(event) }
        }

        return domainFlow
    }

    override fun getEventDetails(eventId: Long): Flow<EventDetailsDomain> {
        val entitiesFlow = eventDao.getEventDetails(eventId)

        val domainFlow = entitiesFlow.map { eventEntity ->
            converter.eventDetails2domain(eventEntity)
        }

        return domainFlow
    }

    override fun setSubscribeToEvent(eventId: Long, setSubscribed: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            eventDao.setEventSubscription(eventId = eventId, subscription = setSubscribed)
        }
    }

    override fun getEventSubscription(eventId: Long): Flow<Boolean> {
        return eventDao.getEventSubscription(eventId)
    }

    override fun getGroupEventsByEventId(eventId: Long): Flow<List<Event>> {
        val entitiesFlow = eventDao.getGroupEventsByEventId(eventId)

        val domainFlow = entitiesFlow.map {
            it.map { event -> converter.event2domain(event) }
        }

        return domainFlow
    }

}