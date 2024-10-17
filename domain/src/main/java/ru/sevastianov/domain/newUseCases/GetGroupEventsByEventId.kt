package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


internal class GetGroupEventsByEventId(
    val repository: IEventsRepository,
    innerIdsFlow: InnerEventDetailsIds
) : IGetGroupEventsByEventId {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = innerIdsFlow.observe().flatMapLatest { id ->
        repository.getGroupEventsByEventId(id)
    }

    override fun execute(): Flow<List<Event>> {
        return result
    }

}

interface IGetGroupEventsByEventId {
    fun execute(): Flow<List<Event>>
}