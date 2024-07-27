package ru.sevastianov.domain.stubRepositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Coordinates
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.models.EventDetails
import ru.sevastianov.domain.models.Participant
import ru.sevastianov.domain.repository.IEventsRepository


class EventsStubRepository : IEventsRepository {

    override fun getActiveEvents(): Flow<List<Event>> {
        val meeting = Event(
            title = "Active meeting",
            place = "13.09.2024 - Москва",
            date = 1735164710,
            isEnded = false,
            imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
            tags = listOf("Python", "Junior", "Moscow")
        )
        val activeEvents = List(10) { meeting }

        return flowOf(activeEvents)
    }

    override fun getAllEvents(): Flow<List<Event>> {
        val allEvents = List(10) { index ->
            Event(
                title = "All event $index",
                place = "13.09.2024 - Москва",
                date = 1735164710,
                isEnded = false,
                imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
                tags = listOf("Python", "Junior", "Moscow")
            )
        }
        return flowOf(allEvents)
    }

    override fun getEventDetails(eventId: Long): Flow<EventDetails> {
        val eventDetails = EventDetails(
            chips = listOf("1", "2", "345"),
            date = 345678,
            place = "Вишневогрск",
            coordinates = Coordinates(56.00, -180.00),
            description = "descr \n \n \n \n 12345",
            iGoing = false,
            participants = listOf(
                Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
                Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
                Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
                Participant("https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png"),
                Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
                Participant("https://live.staticflickr.com/65535/53843918114_2f6a4c1b85_o_d.png"),
                Participant("https://live.staticflickr.com/65535/53844005940_36eb395df8_o_d.jpg"),
            )
        )
        return flowOf(eventDetails)
    }

    override fun getOldEvents(): Flow<List<Event>> {
        val oldEvents = List(10) { index ->
            Event(
                title = "Last event $index",
                place = "13.09.2024 - Москва",
                date = 1720007704,
                isEnded = true,
                imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
                tags = listOf("Python", "Junior", "Moscow")
            )
        }
        return flowOf(oldEvents)
    }

    override fun getPlannedEvents(): Flow<List<Event>> {
        val plannedEvents = List(10) { index ->
            Event(
                title = "Planned event $index",
                place = "13.09.2024 - Москва",
                date = 1729007704,
                isEnded = false,
                imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
                tags = listOf("Python", "Junior", "Moscow")
            )
        }
        return flowOf(plannedEvents)
    }

    override fun setGoToEvent(goingToEvent: Boolean, eventId: Long) {

    }
}