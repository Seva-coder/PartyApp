package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetAllEventsUseCase(private val repository: IEventsRepository) : IGetAllEventsUseCase {

    override fun execute(): Flow<List<Event>> {
        return repository.getAllEvents()
    }

}

interface IGetAllEventsUseCase {
    fun execute(): Flow<List<Event>>
}