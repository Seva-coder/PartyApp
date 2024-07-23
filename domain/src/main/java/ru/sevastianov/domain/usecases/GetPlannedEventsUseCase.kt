package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetPlannedEventsUseCase(private val repository: IEventsRepository) : IGetPlannedEventsUseCase {

    override fun execute(): Flow<List<Event>> {
        return flowOf(mockAllEvents)
    }

    private val mockAllEvents = List(10) { index ->
        Event(
            title = "Planned event $index",
            place = "13.09.2024 - Москва",
            date = 32432432,
            isEnded = false,
            imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
            tags = listOf("Python", "Junior", "Moscow")
        )
    }
}

interface IGetPlannedEventsUseCase {
    fun execute(): Flow<List<Event>>
}