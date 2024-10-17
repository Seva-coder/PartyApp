package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


class GetAllEventsFlow(repository: IEventsRepository) : IGetAllEventsFlow {

    private val result = repository.getAllEvents()

    override fun execute(): Flow<List<Event>> {
        return result
    }
}


interface IGetAllEventsFlow {
    fun execute(): Flow<List<Event>>
}