package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetActiveEventsUseCase(private val repository: IEventsRepository) : IGetActiveEventsUseCase {

    override fun execute(): Flow<List<Event>> {
        return flowOf(mockAllEvents)
    }

    private val meeting = Event(
        title = "Active meeting",
        place = "13.09.2024 - Москва",
        date = 32432432,
        isEnded = false,
        imageUrl = "https://live.staticflickr.com/65535/53843567021_ae8d29049f_o_d.png",
        tags = listOf("Python", "Junior", "Moscow")
    )

    private val mockAllEvents = List(10) { meeting }

}

interface IGetActiveEventsUseCase {
    fun execute(): Flow<List<Event>>
}