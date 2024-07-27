package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


internal class GetOldEventsUseCase(private val repository: IEventsRepository) : IGetOldEventsUseCase {

    override fun execute(): Flow<List<Event>> {
        return repository.getOldEvents()
    }

}


interface IGetOldEventsUseCase {
    fun execute(): Flow<List<Event>>
}