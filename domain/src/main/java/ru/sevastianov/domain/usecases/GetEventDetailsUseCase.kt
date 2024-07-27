package ru.sevastianov.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.sevastianov.domain.models.EventDetails
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetEventDetailsUseCase(private val repository: IEventsRepository) : IGetEventDetails {

    override fun execute(eventId: Long): Flow<EventDetails> {
        return repository.getEventDetails(eventId = eventId)
    }

}


interface IGetEventDetails {
    fun execute(eventId: Long): Flow<EventDetails>
}