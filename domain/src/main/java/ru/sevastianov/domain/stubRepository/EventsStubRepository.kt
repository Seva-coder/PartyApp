package ru.sevastianov.domain.stubRepository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetailsDomain
import ru.sevastianov.domain.repository.IEventsRepository


class EventsStubRepository : IEventsRepository {

    override fun getActiveEvents(): Flow<List<Event>> {
        val meeting = Event(
            eventId = 1L,
            title = "Active meeting",
            place = "13.09.2024 - Москва",
            date = 1735164710,
            //isEnded = false,
            imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
            tags = listOf("Python", "Junior", "Moscow")
        )
        val activeEvents = List(10) { meeting }

        return flowOf(activeEvents)
    }

    override fun getAllEvents(): Flow<List<Event>> {
        val allEvents = List(10) { index ->
            Event(
                eventId = 1L,
                title = "All event $index",
                place = "13.09.2024 - Москва",
                date = 1735164710,
                imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
                tags = listOf("Python", "Junior", "Moscow")
            )
        }
        return flowOf(allEvents)
    }

    override fun getAllEventsByTagId(idSet: Set<Long>): Flow<List<Event>> {
        return flowOf(emptyList())
    }

    override fun getEventsByText(textFilter: String): Flow<List<Event>> {
        return flowOf(emptyList())
    }

    override fun getEventDetails(eventId: Long): Flow<EventDetailsDomain> {

        return flowOf()
    }

    override fun setSubscribeToEvent(eventId: Long, setSubscribed: Boolean) {

    }

    override fun getEventSubscription(eventId: Long): Flow<Boolean> {
        return flowOf()
    }

    override fun getGroupEventsByEventId(eventId: Long): Flow<List<Event>> {
        return flowOf()
    }

    override fun getOldEvents(): Flow<List<Event>> {
        val oldEvents = List(10) { index ->
            Event(
                eventId = 1L,
                title = "Last event $index",
                place = "13.09.2024 - Москва",
                date = 1720007704,
                imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
                tags = listOf("Python", "Junior", "Moscow")
            )
        }
        return flowOf(oldEvents)
    }

    override fun getPlannedEvents(): Flow<List<Event>> {
        val plannedEvents = List(10) { index ->
            Event(
                eventId = 1L,
                title = "Planned event $index",
                place = "13.09.2024 - Москва",
                date = 1729007704,
                imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
                tags = listOf("Python", "Junior", "Moscow")
            )
        }
        return flowOf(plannedEvents)
    }

    override fun setGoToEvent(goingToEvent: Boolean, eventId: Long) {

    }

    ////////
    override fun getAllBigEvents(): Flow<List<Event>> {
        return flowOf(emptyList())
    }

    override fun getNearestEventsFlow(afterTime: Int): Flow<List<Event>> {
        return flowOf(emptyList())
    }
}