package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


internal class GetFiltredEventsFlow(
    val repository: IEventsRepository,
    val textFilter: InnerFilteredEvents
) : IGetFiltredEventsFlow {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = textFilter.observe().flatMapLatest { textSearch ->
        repository.getEventsByText(textSearch)
    }

    override fun execute(): Flow<List<Event>> {
        return result
    }
}


interface IGetFiltredEventsFlow {
    fun execute(): Flow<List<Event>>
}