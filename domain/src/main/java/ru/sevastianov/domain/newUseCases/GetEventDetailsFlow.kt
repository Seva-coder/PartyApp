package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.models.EventDetailsDomain
import ru.sevastianov.domain.repository.IEventsRepository


internal class GetEventDetailsFlow(
    repository: IEventsRepository,
    innerIdsFlow: InnerEventDetailsIds
) : IGetEventDetailsFlow {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = innerIdsFlow.observe().flatMapLatest { id ->
        repository.getEventDetails(id)
    }

    override fun execute(): Flow<EventDetailsDomain> {
        return result
    }

}


interface IGetEventDetailsFlow {
    fun execute(): Flow<EventDetailsDomain>
}