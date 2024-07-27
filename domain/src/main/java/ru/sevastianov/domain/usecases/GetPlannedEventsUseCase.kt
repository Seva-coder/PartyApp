package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetPlannedEventsUseCase(private val repository: IEventsRepository) : IGetPlannedEventsUseCase {

    override fun execute(): Flow<List<Event>> {
        return repository.getPlannedEvents()
    }

}

interface IGetPlannedEventsUseCase {
    fun execute(): Flow<List<Event>>
}