package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import org.koin.core.component.KoinComponent
import ru.sevastianov.domain.models.Event
import ru.sevastianov.domain.repository.IEventsRepository


internal class GetNearestEventsFlow(
    val eventsRepository: IEventsRepository,
    innerNearestTimes: InnerNearestEvents
) : KoinComponent, IGetNearestEventsFlow {

    @OptIn(ExperimentalCoroutinesApi::class)
    val result = innerNearestTimes.observe().flatMapLatest { afterTime ->
        eventsRepository.getNearestEventsFlow(afterTime)
    }

    override fun execute(): Flow<List<Event>> = result
}

interface IGetNearestEventsFlow {
    fun execute(): Flow<List<Event>>
}