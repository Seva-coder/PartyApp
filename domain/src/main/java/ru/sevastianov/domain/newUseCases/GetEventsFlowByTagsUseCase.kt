package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


internal class GetEventsFlowByTagsUseCase(
    val repository: IEventsRepository,
    idsFlow: InnerSelectedEventTags
) : IGetEventsFlowByTags {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = idsFlow.observe().flatMapLatest { ids ->
        repository.getAllEventsByTagId(ids)
    }

    override fun execute(): Flow<List<Event>> = result

}

interface IGetEventsFlowByTags {
    fun execute(): Flow<List<Event>>
}