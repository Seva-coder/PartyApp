package ru.sevastianov.domain.newUseCases

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import ru.sevastianov.domain.repository.IEventsRepository

internal class GetCurrentEventSubscription(
    val repository: IEventsRepository,
    innerIdsFlow: InnerEventDetailsIds
) : IGetCurrentEventSubscription {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val result = innerIdsFlow.observe().flatMapLatest { id ->
        repository.getEventSubscription(id)
    }

    override fun execute(): Flow<Boolean> {
        return result
    }

}


interface IGetCurrentEventSubscription {
    fun execute(): Flow<Boolean>
}