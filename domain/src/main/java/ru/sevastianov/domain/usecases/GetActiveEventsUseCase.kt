package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetActiveEventsUseCase(private val repository: IEventsRepository) : IGetActiveEventsUseCase {

    override fun execute(): Flow<List<Event>> {
        return repository.getActiveEvents()
    }

}

interface IGetActiveEventsUseCase {
    fun execute(): Flow<List<Event>>
}